package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/3/21
 * @Description: 公共删除标记：0->正常; 1->删除标记, 状态 0 是默认状态
 */
public enum DeleteStatus {
    NORMAL(0,"正常"),
    DELETE_FLAG(1,"删除标记");

    private int status;
    private String description;

    private DeleteStatus(int status, String description) {
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
