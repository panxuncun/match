package com.guet.match.controller;

import com.guet.match.common.CommonPage;
import com.guet.match.common.CommonResult;
import com.guet.match.common.Events;
import com.guet.match.common.States;
import com.guet.match.dto.OrderDTO;
import com.guet.match.dto.OrderParam;
import com.guet.match.dto.QueryOrderParam;
import com.guet.match.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private StateMachine<States, Events> stateMachine;


    @ApiOperation("创建订单,需要必要的报名信息")
    @PostMapping("order/add")
    public CommonResult addOrder(@RequestBody OrderParam dto) {
        return orderService.createOrder(dto);
    }

    @ApiOperation("小程序申请退款（取消订单）")
    @PostMapping("order/applyRefund/{orderId}")
    public CommonResult applyRefund(@PathVariable Long orderId){
        return orderService.applyRefund(orderId);
    }

    @ApiOperation("付款")
    @PostMapping("order/pay/{orderId}")
    public CommonResult pay(@PathVariable Long orderId) {
        switch (orderService.pay(orderId)) {
            case 0:
                return CommonResult.failed("支付失败，正在给您办理退款，请注意查收");
            case 1:
                return CommonResult.success(null);
            case 2:
                return CommonResult.failed("订单已失效，正在给您办理退款，请注意查收");
            case 4:
                return CommonResult.failed("您已付款，请勿重复操作");
            default:
                return CommonResult.failed(null);
        }
    }

    @ApiOperation("取消未付款订单")
    @PostMapping("order/cancel/{orderId}")
    public CommonResult cancel(@PathVariable long orderId) {
        return orderService.cancel(orderId) == 1 ? CommonResult.success(null) : CommonResult.failed("操作失败，请刷新页面");
    }

    @ApiOperation("删除订单（设置删除标记）")
    @PostMapping("order/delete/{orderId}")
    public CommonResult delete(@PathVariable long orderId) {
        return orderService.deleteOrderById(orderId) == 1 ? CommonResult.success(null) : CommonResult.failed("操作失败，请刷新页面");
    }

    //orderStatus参阅comon/PaymentStatus
    @ApiOperation("查看订单by openId")
    @GetMapping("order/listByOpenId")
    public CommonResult getOrderList(@RequestParam(required = true) String openId,
                                     @RequestParam(required = false) Integer paymentStatus,
                                     @RequestParam(required = false, value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<OrderDTO> list = orderService.getOrderListByOpenId(openId, paymentStatus, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }


    //orderStatus参阅comon/PaymentStatus
    @ApiOperation("查看订单by contestId")
    @GetMapping("order/listByContestId")
    public CommonResult getOrderList(@RequestParam(required = true) Long contestId,
                                     @RequestParam(required = false) Long groupId) {
        return CommonResult.success(orderService.getOrderListByContestId(contestId, groupId));
    }


    @ApiOperation("状态机测试")
    @GetMapping("order/testMachine")
    public String testMachine() {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
        return "ok";
    }

    @ApiOperation("主办方：获取订单")
    @GetMapping("order/listByQuery")
    public CommonResult getOrderList(QueryOrderParam param,
                                     @RequestParam(required = false, value = "page", defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, value = "limit", defaultValue = "5") Integer pageSize) {
        return orderService.listOrderByQuery(param, pageNum, pageSize);
    }


    @ApiOperation("批量同意退款")
    @PostMapping("order/batchAgreeRefund")
    public CommonResult batchAgreeRefund(@RequestBody List<Long> ids){
        return orderService.batchAgreeRefund(ids);
    }

    @ApiOperation("批量拒绝退款")
    @PostMapping("order/batchRefuseRefund")
    public CommonResult batchRefuseRefund(@RequestBody List<Long> orderIds){
        return orderService.batchRefuseRefund(orderIds);
    }

    @ApiOperation("批量取消订单")
    @PostMapping("order/batchCancelOrder")
    public CommonResult batchCancelOrder(@RequestBody List<Long> orderIds){
        return orderService.batchRefund(orderIds);
    }
}
