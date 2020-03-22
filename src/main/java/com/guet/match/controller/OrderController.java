package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.dto.OrderDto;
import com.guet.match.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sefer
 * @Date: 2020/3/22
 * @Description: 订单控制器
 */

@Api(tags = "订单")
@RestController
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;


    @ApiOperation("创建订单,需要必要的报名信息")
    @PostMapping("order/add")
    public CommonResult addOrder(@RequestBody OrderDto dto) {
        Long orderId = orderService.createOrder(dto);
        switch (orderId.intValue()) {
            case -2:
                return CommonResult.failed("您已报名，同一小组只能报名一次哦~");
            case -1:
                return CommonResult.failed("订单创建失败，请刷新页面并重新报名");
            case -3:
                return CommonResult.failed("来晚了一步，名额已满");
            default:
                return CommonResult.success(orderId,"已为你锁定名额，请在30分钟内完成支付");
        }

    }
}
