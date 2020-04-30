package com.guet.match.mapper;

import com.guet.match.dto.OrderDTO;
import com.guet.match.model.OmsOrder;
import com.guet.match.model.OmsOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmsOrderMapper {
    int countByExample(OmsOrderExample example);

    int deleteByExample(OmsOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrder record);

    int insertSelective(OmsOrder record);

    List<OmsOrder> selectByExample(OmsOrderExample example);

    OmsOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsOrder record, @Param("example") OmsOrderExample example);

    int updateByExample(@Param("record") OmsOrder record, @Param("example") OmsOrderExample example);

    int updateByPrimaryKeySelective(OmsOrder record);

    int updateByPrimaryKey(OmsOrder record);

    //清除过期订单
    int cleanExpiredOrder(int expiredMinute);

    //获取过期订单
    List<OmsOrder> getExpiredOrderList(@Param("expiredMinute") int expiredMinute,@Param("status") int status);

    //锁订单
    int lockOrder(@Param("orderId") long orderId,@Param("status") int status);

    //小程序获取订单
    List<OrderDTO> getOrderListByOpenIdAndStatus(@Param("openId") String openId,@Param("status") int status);

    //小程序获取全部订单
    List<OrderDTO> getAllOrderListByOpenId(@Param("openId") String  openId);

}