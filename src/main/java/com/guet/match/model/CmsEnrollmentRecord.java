package com.guet.match.model;

import java.util.Date;

public class CmsEnrollmentRecord {
    private Long id;

    private Long contestId;

    private Long contestGroupId;

    private String openId;

    private Integer type;

    private Date createTime;

    private String mailAddress;

    private String contestantNumber;

    private String contestantStatus;

    private String contestantRank;

    private String contestantAchievement;

    private String contestantAward;

    private Integer status;

    private String contestantRealName;

    private String contestantIdCard;

    private Long orderId;

    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public Long getContestGroupId() {
        return contestGroupId;
    }

    public void setContestGroupId(Long contestGroupId) {
        this.contestGroupId = contestGroupId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getContestantNumber() {
        return contestantNumber;
    }

    public void setContestantNumber(String contestantNumber) {
        this.contestantNumber = contestantNumber;
    }

    public String getContestantStatus() {
        return contestantStatus;
    }

    public void setContestantStatus(String contestantStatus) {
        this.contestantStatus = contestantStatus;
    }

    public String getContestantRank() {
        return contestantRank;
    }

    public void setContestantRank(String contestantRank) {
        this.contestantRank = contestantRank;
    }

    public String getContestantAchievement() {
        return contestantAchievement;
    }

    public void setContestantAchievement(String contestantAchievement) {
        this.contestantAchievement = contestantAchievement;
    }

    public String getContestantAward() {
        return contestantAward;
    }

    public void setContestantAward(String contestantAward) {
        this.contestantAward = contestantAward;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContestantRealName() {
        return contestantRealName;
    }

    public void setContestantRealName(String contestantRealName) {
        this.contestantRealName = contestantRealName;
    }

    public String getContestantIdCard() {
        return contestantIdCard;
    }

    public void setContestantIdCard(String contestantIdCard) {
        this.contestantIdCard = contestantIdCard;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}