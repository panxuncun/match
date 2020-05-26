package com.guet.match.service;

import com.github.pagehelper.PageHelper;
import com.guet.match.common.CommonPage;
import com.guet.match.common.CommonResult;
import com.guet.match.common.EnrollmentStatus;
import com.guet.match.common.PaymentStatus;
import com.guet.match.dto.OrderDTO;
import com.guet.match.dto.OrderParam;
import com.guet.match.dto.QueryContestParam;
import com.guet.match.dto.QueryOrderParam;
import com.guet.match.mapper.CmsContestGroupMapper;
import com.guet.match.mapper.CmsEnrollmentRecordMapper;
import com.guet.match.mapper.OmsOrderMapper;
import com.guet.match.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/3/22
 * @Description: 订单
 */
@Service
public class OrderService {
    Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private OmsOrderMapper orderMapper;

    @Autowired
    private CmsEnrollmentRecordMapper enrollmentRecordMapper;

    @Autowired
    private CmsContestGroupMapper groupMapper;


    //判断是否重复报名(同一小组 & 同一证件号)
    public boolean hasEnrollmentRecord(OrderParam dto) {
        CmsEnrollmentRecordExample example = new CmsEnrollmentRecordExample();
        example.createCriteria().andContestGroupIdEqualTo(dto.getContestGroupId()).andContestantIdCardEqualTo(dto.getContestantIdCard());
        if (enrollmentRecordMapper.selectByExample(example).size() == 0) {
            logger.info("未报名,原始参数:{}",dto.toString());
            return false;
        }
        logger.info("已有报名记录,原始参数:{}",dto.toString());
        return true;
    }

    //得到订单价格by group id。错误则返回-1
    public BigDecimal getPrice(long id) {
        CmsContestGroup group = groupMapper.selectByPrimaryKey(id);
        if (group == null) {
            return BigDecimal.valueOf(-1);
        }
        return group.getPrice();
    }


    //添加订单,先有订单，后有记录.  -1->创建失败;  -2->已报名，拒绝订单创建;  -3->可用名额不足;  正整数(订单号)->创建成功;
    // 临时创建报名记录，因为携带了很多参数，报名记录有一个字段叫 order_id,可以追溯来源的
    // 加入不存在的赛事，不存的组别，会错误，但是我还每排查出来
    public CommonResult createOrder(OrderParam dto) {
        //判断是否已报名
        if (hasEnrollmentRecord(dto)) {
            logger.info("已报名，拒绝订单创建");
            return CommonResult.failed("您已报名~");
        }
        //判断是否剩余名额
        Integer usableSize = groupMapper.getUsableSize(dto.getContestGroupId());
        if (usableSize == null){
            logger.info("组别不存在，原始参数contestGroupId{}",dto.getContestGroupId());
            return CommonResult.failed("组别不存在");
        }
        if (usableSize < 1) {
            logger.info("可用名额不足,usableSize->{}",usableSize);
            return CommonResult.failed("来晚了一步，名额已满");
        }
        OmsOrder order = new OmsOrder();
        BeanUtils.copyProperties(dto, order);
        //根据组别得到准确价格，错误时返回-1
        BigDecimal price = getPrice(dto.getContestGroupId());
        if (price.intValue() == -1) {
            logger.error("订单创建失败。严重错误的参数：组别不存在。");
            return CommonResult.failed("组别不存在,请刷新页面重试");
        }
        order.setPrice(price);
        order.setStatus(PaymentStatus.UNPAID.getStatus());

        //组别名额减1，生成订单（未支付状态）
        groupMapper.sizeMinus(dto.getContestGroupId());
        orderMapper.insertSelective(order);
        //保存报名数据（订单不会保存这些，交给报名记录来）todoo
        CmsEnrollmentRecord record = new CmsEnrollmentRecord();
        BeanUtils.copyProperties(dto,record);
        record.setOrderId(order.getId());
        record.setStatus(EnrollmentStatus.TEMP.getStatus());
        enrollmentRecordMapper.insertSelective(record);
        //返回订单号
        return CommonResult.success(order.getId());
    }

    //订单支付 return: 0->支付失败; 1->支付成功; 2->订单失效; 4->已付款
    public int pay(long id) {
        //尝试临时锁定订单，防止被清除
        int count = orderMapper.lockOrder(id, PaymentStatus.LOCK.getStatus());
        if (count == 0) {
            logger.error("无效的订单号，订单已失效");
            return 2;
        }
        //获得订单，并判断是否已付款
        OmsOrder order = orderMapper.selectByPrimaryKey(id);
        if (order.getStatus() == PaymentStatus.PAID.getStatus()) {
            logger.error("试图重复付款，订单号" + id);
            return 4;
        }
        //更新订单状态和支付时间
        order.setStatus(PaymentStatus.PAID.getStatus());
        order.setPaymentTime(new Date());
        if (orderMapper.updateByPrimaryKey(order) == 0) {
            //todo 退款
            logger.error("无法更新订单状态，方法pay，订单号->{}", id);
            return 0;
        }
        //更新报名记录状态
        CmsEnrollmentRecordExample example = new CmsEnrollmentRecordExample();
        example.createCriteria().andOrderIdEqualTo(id);
        CmsEnrollmentRecord record = enrollmentRecordMapper.selectByExample(example).get(0);
        if (record == null){
            logger.error("找不到原始报名数据，方法pay，订单号->{}", id);
        }
        //支付后就是待审核状态
        record.setStatus(EnrollmentStatus.WAIT.getStatus());
        if (enrollmentRecordMapper.updateByPrimaryKey(record) == 0){
            logger.error("无法更新报名数据，方法pay，订单号->{}, 报名记录id->{}", id,record.getId());
        }
        logger.info("支付成功, 订单号->{}", id);
        return 1;
    }

    //关闭未付款订单（直接删除）(针对未支付订单)
    public int cancel(long id) {
        OmsOrder order = orderMapper.selectByPrimaryKey(id);
        if (order == null) {
            logger.info("订单不存在，可能被清除。订单id->{}", id);
            return 0;
        }
        if (order.getStatus() != PaymentStatus.UNPAID.getStatus()) {
            logger.error("只有未付款的订单可以取消，已完成（已付款、已退款）的订单不可取消");
            return 0;
        }
        return orderMapper.deleteByPrimaryKey(id);
    }

    //小程序申请退款（取消订单）
    public CommonResult applyRefund(Long orderId){
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            logger.info("订单不存在，可能被清除。订单id->{}", orderId);
            return CommonResult.failed("订单不存在");
        }
        if (order.getStatus() != PaymentStatus.PAID.getStatus()){
            return CommonResult.failed("只有已支付的订单才能申请退款");
        }
        order.setStatus(PaymentStatus.APPLY_REFUND.getStatus());
        orderMapper.updateByPrimaryKey(order);
        return CommonResult.success(null);
    }

    //删除订单（针对已完成订单，设置删除标志位）
    public int deleteOrderById(long orderId) {
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            logger.error("删除订单错误，不存的订单id->{}", orderId);
            return 0;
        }
        order.setStatus(PaymentStatus.DELETE_FLAG.getStatus());
        return orderMapper.updateByPrimaryKey(order);
    }

    //查看订单 By OpenId
    public List<OrderDTO> getOrderListByOpenId(String openId, Integer paymentStatus,Integer pageNum,Integer pageSize) {
        if (openId == null){
            logger.error("小程序端查看订单, 非法的参数: openId->null");
            return null;
        }

        //分页
        PageHelper.startPage(pageNum,pageSize);

        if (paymentStatus == null) {
            logger.info("查询全部订单，原始参数 openId->{}", openId);
            return orderMapper.getAllOrderListByOpenId(openId);
        }

        logger.info("查询部分订单，原始参数 openId->{}, paymentStatus->{}", openId, paymentStatus);
        return orderMapper.getOrderListByOpenIdAndStatus(openId, paymentStatus);
    }

    //查看订单 By contest
    public List<OmsOrder> getOrderListByContestId(Long contestId, Long gruopId) {
        OmsOrderExample example = new OmsOrderExample();
        if (gruopId == null) {
            logger.info("查询全部订单，原始参数 contestId->{}", contestId);
            example.createCriteria().andContestIdEqualTo(contestId);
        } else {
            logger.info("查询部分订单，原始参数 contestId->{}, gruopId->{}", contestId, gruopId);
            //todo 这里的contestId没有必要
            example.createCriteria().andContestIdEqualTo(contestId).andContestGroupIdEqualTo(gruopId);
        }
        return orderMapper.selectByExample(example);
    }



    //取消退款申请（用户）
    public int cancelRefund(long orderId) {
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            return 0;
        }
        if (order.getStatus() != PaymentStatus.APPLY_REFUND.getStatus()) {
            logger.error("未申请退款，无法取消退款，订单号{}, 当前订单状态{}", orderId, order.getStatus());
            return 0;
        }
        order.setStatus(PaymentStatus.REFUND.getStatus());
        return orderMapper.updateByPrimaryKey(order);
    }


    //同意退款（主办方）
    public int Refund(long orderId) {
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            logger.error("无效的订单号" + orderId);
            return 0;
        }
        if (order.getStatus() != PaymentStatus.APPLY_REFUND.getStatus()) {
            logger.error("该订单已取消退款申请，订单号" + orderId + "当前订单状态" + order.getStatus());
            return 0;
        }
        order.setStatus(PaymentStatus.REFUND.getStatus());
        return orderMapper.updateByPrimaryKey(order);
    }


    /**
     * 公共方法
     * 批量退款,即取消订单
     * @param ids 订单ids，由contestService传入
     *            ids为空说明有报名记录，但是无订单，是严重的错误
     * @return CommonResult
     */
    public CommonResult batchRefund(List<Long> ids){
        if (ids == null || ids.size() == 0) {
            logger.error("错误：找不到关联的订单");
            return CommonResult.failed("没有对应的订单数据");
        }

        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdIn(ids);
        List<OmsOrder> list = orderMapper.selectByExample(example);

        //判断状态是否为 “已支付”
        for (OmsOrder item:list){
            if (item.getStatus()!= PaymentStatus.PAID.getStatus()){
                String errMsg = "只有已支付的订单可以申请退款。编号为" + item.getId() + "的订单不合法";
                return CommonResult.failed(errMsg);
            }
        }

        //更新
        list.stream().forEach(item->{
            //更新订单
            item.setStatus(PaymentStatus.REFUND.getStatus());
            orderMapper.updateByPrimaryKey(item);
            //回库
            groupMapper.sizePlus(item.getContestGroupId());
        });

        return CommonResult.success(null);
    }

    /**
     * 批量同意退款
     * 针对已经申请的订单
     * @param orderIds
     * @return
     */
    @Transactional
    public CommonResult batchAgreeRefund(List<Long> orderIds){
        if (orderIds == null || orderIds.size() == 0) {
            return CommonResult.failed("orderIds不能为空");
        }
        logger.info("批量同意退款, orderIds->{}",orderIds);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdIn(orderIds);
        List<OmsOrder> orderList = orderMapper.selectByExample(example);

        //判断状态是否为 “申请退款”
        for (OmsOrder item:orderList){
            if (item.getStatus()!= PaymentStatus.APPLY_REFUND.getStatus()){
                String errMsg = "错误：编号为" + item.getId() + "的订单未申请退款";
                return CommonResult.failed(errMsg);
            }
        }

        //更新，设置报名为“拒绝参赛”态。
        CmsEnrollmentRecordExample recordExample = new CmsEnrollmentRecordExample();
        recordExample.createCriteria().andOrderIdIn(orderIds);
        List<CmsEnrollmentRecord> recordList = enrollmentRecordMapper.selectByExample(recordExample);
        recordList.stream().forEach(item->{
            item.setStatus(EnrollmentStatus.REFUSE.getStatus());
            enrollmentRecordMapper.updateByPrimaryKey(item);
        });


        //开始退款
        orderList.stream().forEach(item->{
            //更新订单
            item.setStatus(PaymentStatus.REFUND.getStatus());
            orderMapper.updateByPrimaryKey(item);
            //回库
            groupMapper.sizePlus(item.getContestGroupId());
        });
        return CommonResult.success(null);
    }

    /**
     * 批量拒绝退款
     * 针对已经申请的订单
     * @param orderIds
     * @return
     */
    public CommonResult batchRefuseRefund(List<Long> orderIds){
        if (orderIds == null || orderIds.size() == 0) {
            return CommonResult.failed("orderIds不能为空");
        }
        logger.info("批量拒绝退款, orderIds->{}",orderIds);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdIn(orderIds);
        List<OmsOrder> orderList = orderMapper.selectByExample(example);

        //判断状态是否为 “申请退款”
        for (OmsOrder item:orderList){
            if (item.getStatus()!= PaymentStatus.APPLY_REFUND.getStatus()){
                String errMsg = "错误：编号为" + item.getId() + "的订单未申请退款";
                return CommonResult.failed(errMsg);
            }
        }

        //拒绝退款：报名记录不变，订单状态回归正常（“已支付”）状态
        orderList.stream().forEach(item->{
            item.setStatus(PaymentStatus.PAID.getStatus());
            orderMapper.updateByPrimaryKey(item);
        });
        return CommonResult.success(null);
    }


    //拒绝退款（主办方）
    public int refuseRefund(long orderId) {
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            logger.error("无效的订单号" + orderId);
            return 0;
        }
        if (order.getStatus() != PaymentStatus.APPLY_REFUND.getStatus()) {
            logger.error("该订单已取消退款申请，订单号" + orderId + "当前订单状态" + order.getStatus());
            return 0;
        }
        order.setStatus(PaymentStatus.PAID.getStatus());
        order.setNote("拒绝理由");
        return orderMapper.updateByPrimaryKey(order);
    }

    //主办方：获取订单
    public CommonResult listOrderByQuery(QueryOrderParam param, Integer pageNum, Integer pageSize) {
        OmsOrderExample example = new OmsOrderExample();
        example.setOrderByClause("id desc");
        OmsOrderExample.Criteria criteria = example.createCriteria();
        criteria.andContestIdEqualTo(param.getContestId());
        if (param.getId() != null) {
            criteria.andIdEqualTo(param.getId());
        }

        if (param.getGroupId() != null){
            criteria.andContestGroupIdEqualTo(param.getGroupId());
        }


        if (param.getStatus() != null) {
            criteria.andStatusEqualTo(param.getStatus());
        }

        PageHelper.startPage(pageNum, pageSize);
        List<OmsOrder> list = orderMapper.selectByExample(example);
        return CommonResult.success(CommonPage.restPage(list));
    }


}
