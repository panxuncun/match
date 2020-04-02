package com.guet.match.dto;

import com.guet.match.model.OmsOrder;

/**
 * @Auther: sefer
 * @Date: 2020/4/3
 * @Description: 小程序端订单：新加赛事名称、组别名称、参赛者姓名、证件号码
 */
public class OrderDTO extends OmsOrder {
    //赛事名称
    private String contestName;
    //组别名称
    private String groupName;
    //参赛者真实姓名
    private String realName;
    //证件号码
    private String idCard;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "contestName='" + contestName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", realName='" + realName + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
