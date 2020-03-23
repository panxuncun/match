package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/3/24
 * @Description: 状态机状态（节点？） 看这里https://blog.csdn.net/gwd1154978352/article/details/79577597
 */
public enum States {
    UNPAID,                 // 待支付
    WAITING_FOR_RECEIVE,    // 待收货
    DONE                    // 结束
}
