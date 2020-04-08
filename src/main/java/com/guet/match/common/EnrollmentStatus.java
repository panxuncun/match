package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/4/6
 * @Description: 报名记录状态
 */
public enum EnrollmentStatus {
    NORMAL(0,"正常，已支付"),
    DELETE_FLAG(1,"删除标记"),
    TEMP(2,"订单衍生的临时数据，未支付");

    private int status;
    private String description;

    private EnrollmentStatus(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
