package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/3/25
 * @Description: 主办方状态
 */
public enum OrganizerStatus {
    INIT(-1,"注册后的初始态"),
    WAIT(0,"等待审核"),
    PASS(1,"审核通过"),
    REFUSE(2,"未通过"),
    OFF(3,"停用"),
    DELETE_FLAG(4,"删除标记");

    private int status;
    private String description;


    private OrganizerStatus(int status, String description) {
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
