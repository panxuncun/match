package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/3/20
 * @Description: 报名dto
 */
public class EnrollmentDto {

    //赛事
    private Long contestId;

    //组别
    private Long contestGroupId;

    //用户
    private String openId;

    //邮寄地址
    private String mailAddress;

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

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}
