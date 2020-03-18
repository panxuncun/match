package com.guet.match.dto;

import com.guet.match.model.CmsContest;
import com.guet.match.model.CmsContestExtensionProperty;
import com.guet.match.model.CmsContestGroup;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/3/18
 * @Description:赛事拓展dto = contest + group
 */
public class ContestDto {
    private CmsContest contest;

    public CmsContest getContest() {
        return contest;
    }

    public void setContest(CmsContest contest) {
        this.contest = contest;
    }

    private List<CmsContestGroup> groupList;
    private List<CmsContestExtensionProperty> extensionPropertyList;

    public List<CmsContestGroup> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<CmsContestGroup> groupList) {
        this.groupList = groupList;
    }

    public List<CmsContestExtensionProperty> getExtensionPropertyList() {
        return extensionPropertyList;
    }

    public void setExtensionPropertyList(List<CmsContestExtensionProperty> extensionPropertyList) {
        this.extensionPropertyList = extensionPropertyList;
    }

    @Override
    public String toString() {
        return "ContestDto{" +
                "groupList=" + groupList +
                ", extensionPropertyList=" + extensionPropertyList +
                '}';
    }
}
