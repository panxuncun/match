package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/4/29
 * @Description: 主办方：筛选报名管理
 */
public class QueryEnrollmentParam {

    //赛事id，这个可以用凭证优化
    private Long contestId;

    //报名id
    private Long id;

    //姓名
    private String keyword;

    //审核状态
    private Integer status;

    //组别
    private Long groupId;

    //号码牌
    private String constantNumber;

    @Override
    public String toString() {
        return "QueryEnrollmentParam{" +
                "contestId=" + contestId +
                ", id=" + id +
                ", keyword='" + keyword + '\'' +
                ", status=" + status +
                ", groupId=" + groupId +
                ", constantNumber='" + constantNumber + '\'' +
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getConstantNumber() {
        return constantNumber;
    }

    public void setConstantNumber(String constantNumber) {
        this.constantNumber = constantNumber;
    }
}
