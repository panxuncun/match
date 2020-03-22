package com.guet.match.service;

import com.guet.match.dto.OrderDto;
import com.guet.match.mapper.CmsContestGroupMapper;
import com.guet.match.mapper.CmsEnrollmentRecordMapper;
import com.guet.match.mapper.OmsOrderMapper;
import com.guet.match.model.CmsContestGroup;
import com.guet.match.model.CmsEnrollmentRecordExample;
import com.guet.match.model.OmsOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Auther: sefer
 * @Date: 2020/3/22
 * @Description:
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

    //判断是否重复报名(同一比赛 & 同一小组)
    public boolean hasEnrollmentRecord(OrderDto dto){
        CmsEnrollmentRecordExample example = new CmsEnrollmentRecordExample();
        example.createCriteria().andOpenIdEqualTo(dto.getOpenId()).andContestIdEqualTo(dto.getContestId()).andContestGroupIdEqualTo(dto.getContestGroupId());
        if (enrollmentRecordMapper.selectByExample(example).size() == 0) {
            logger.info("未报名");
            return false;
        }
        logger.info("已有报名记录");
        return true;
    }

    //得到订单价格by group id
    public BigDecimal getPrice(long id){
        CmsContestGroup group = groupMapper.selectByPrimaryKey(id);
        if (group == null) {
            return BigDecimal.valueOf(-1);
        }
        return group.getPrice();
    }

    //添加订单,先有订单，后有记录.  -1->创建失败;  -2->已报名，拒绝订单创建;  -3->可用名额不足;  正整数(订单号)->创建成功;
    public Long createOrder(OrderDto dto){
        //判断是否已报名
        if (hasEnrollmentRecord(dto)){
            logger.info("已报名，拒绝订单创建");
            return -2L;
        }
        //判断是否剩余名额
        if (groupMapper.getUsableSize(dto.getContestGroupId())<1){
            logger.info("可用名额不足");
            return -3L;
        }
        OmsOrder order = new OmsOrder();
        BeanUtils.copyProperties(dto,order);
        //根据组别得到准确价格
        BigDecimal price = getPrice(dto.getContestGroupId());
        if (price.intValue() == -1){
            logger.error("订单创建失败。严重错误的参数：组别不存在。");
            return 0L;
        }
        order.setPrice(price);
        order.setStatus(0);
        //组别容量减1，同时生成订单（未支付状态）
        groupMapper.sizeMinus(dto.getContestGroupId());
        orderMapper.insertSelective(order);
        return order.getId();
    }

    //订单支付
    public int payOrder(long id){
        //todo
        return 0;
    }

}
