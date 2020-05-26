package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/4/6
 * @Description: 报名记录状态, 主办方只显示 0, 3, 4
 */
public enum EnrollmentStatus {
    WAIT(0,"已支付,待审核"),
    DELETE_FLAG(1,"删除标记"),
    TEMP(2,"订单衍生的临时数据，未支付"),
    PASS(3, "审核通过，报名成功"),
    REFUSE(4, "审核未通过，报名失败"),
    CONTEST_CANCEL(5, "赛事取消导致报名无效");

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
