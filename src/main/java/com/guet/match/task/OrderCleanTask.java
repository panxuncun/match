package com.guet.match.task;

import com.guet.match.common.PaymentStatus;
import com.guet.match.mapper.CmsContestGroupMapper;
import com.guet.match.mapper.OmsOrderMapper;
import com.guet.match.model.OmsOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/3/22
 * @Description: 清除超时未支付订单
 */
@Component
public class OrderCleanTask {
    @Autowired
    private OmsOrderMapper orderMapper;

    @Autowired
    private CmsContestGroupMapper groupMapper;

    Logger logger = LoggerFactory.getLogger(OrderCleanTask.class);

    //清除过期订单，每分钟扫描一次
    @Scheduled(fixedRate = 1000 * 60 * 30)
    public void cleanExpiredOrder() {
        try {
            //设置过期时间，并得到所有过期订单
            List<OmsOrder> list = orderMapper.getExpiredOrderList(5, PaymentStatus.UNPAID.getStatus());
            for (OmsOrder order:list){
                long groupId = order.getContestGroupId();
                //删除订单
                orderMapper.deleteByPrimaryKey(order.getId());
                //回库(可用名额+1)
                groupMapper.sizePlus(groupId);
                logger.info("回库组别{}",groupId);
            }
        } catch (Exception e) {
            logger.error("过期订单清除任务严重错误");
        }
    }
}
