package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/3/20
 * @Description: 参赛者状态：0->未参赛; 1->未完赛; 2->完赛
 */
public enum ConstantStatus {
    NOT_JOIN(0,"未参赛"),
    NOT_FINISH(1,"未完赛"),
    FINISH(2,"完赛");

    private int status;
    private String description;

    private ConstantStatus(int status, String description) {
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
