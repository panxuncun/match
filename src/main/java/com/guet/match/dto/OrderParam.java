package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/3/20
 * @Description: 报名所需的参数，报名将触发创建订单
 */
public class OrderParam {

    //todo 赛事 id(实际上这个是多余的)
    private Long contestId;

    //组别 id
    private Long contestGroupId;

    //用户 openid
    private String openId;

    //邮寄地址
    private String mailAddress;

    //后面新加4.6
    //参赛者姓名
    private String contestantRealName;

    //证件号码
    private String contestantIdCard;

    //手机号
    private String phoneNumber;

    //备注
    private String note;

    @Override
    public String toString() {
        return "OrderParam{" +
                "contestId=" + contestId +
                ", contestGroupId=" + contestGroupId +
                ", openId='" + openId + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", contestantRealName='" + contestantRealName + '\'' +
                ", contestantIdCard='" + contestantIdCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}
