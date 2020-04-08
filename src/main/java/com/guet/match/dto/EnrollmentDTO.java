package com.guet.match.dto;

import com.guet.match.model.CmsEnrollmentRecord;

import java.util.Date;

/**
 * @Auther: sefer
 * @Date: 2020/4/4
 * @Description: 我的赛事（报名信息）
 */
public class EnrollmentDTO extends CmsEnrollmentRecord {
    //赛事名称
    private String contestName;

    //比赛时间
    private Date contestTime;

    //logo(前端需要加oss地址)
    private String logo;

    //组别名称
    private String groupName;

    @Override
    public String toString() {
        return "EnrollmentDTO{" +
                "contestName='" + contestName + '\'' +
                ", logo='" + logo + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    public Date getContestTime() {
        return contestTime;
    }

    public void setContestTime(Date contestTime) {
        this.contestTime = contestTime;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
