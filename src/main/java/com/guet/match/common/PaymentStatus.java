package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/3/23
 * @Description: 支付状态: 0->未支付;1->已支付;2->申请退款; 3->已退款; 4->临时加锁
 */
public enum PaymentStatus {
    UNPAID(0,"未支付"),
    PAID(1,"已支付"),
    APPLY_REFUND(2,"申请退款"),
    REFUND(3, "已退款"),
    LOCK(4,"暂时锁定以防清除");

    private int status;
    private String description;

    private PaymentStatus(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
