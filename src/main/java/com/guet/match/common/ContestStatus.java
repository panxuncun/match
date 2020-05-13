package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/3/20
 * @Description: 赛事状态 0->等待审核; 1->审核通过; 2->未通过; 3->标记删除、4->赛事取消,状态 0 是默认状态
 * 通过取消，可以查看
 * 未通过取消，直接删除了
 */
public enum ContestStatus {
    WAIT(0,"等待审核"),
    PASS(1,"审核通过"),
    REFUSE(2,"未通过"),
    DELETE_FLAG(3,"删除标记"),
    CANCEL(4,"通过后取消，可以查看"),
    REFUSE_AND_CANCEL(4,"拒绝后取消，可以查看");

    private int status;
    private String description;


    private ContestStatus(int status, String description) {
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
