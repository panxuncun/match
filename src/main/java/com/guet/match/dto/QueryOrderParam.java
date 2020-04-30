package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/4/30
 * @Description: 主办方获取订单列表
 */
public class QueryOrderParam {
    //订单号
    private Long id;

    //赛事id
    private Long contestId;

    //组别
    private Long groupId;

    //订单状态
    private Integer status;

    @Override
    public String toString() {
        return "QueryOrderParam{" +
                "id=" + id +
                ", contestId=" + contestId +
                ", groupId=" + groupId +
                ", status=" + status +
                '}';
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
