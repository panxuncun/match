package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/3/20
 * @Description: 报名所需的参数，报名将触发创建订单
 */
public class OrderParam {

    //赛事 id
    private Long contestId;

    //组别 id
    private Long contestGroupId;

    //用户 openid
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
