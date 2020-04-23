package com.guet.match.dto;

import com.guet.match.model.CmsContest;
import com.guet.match.model.CmsContestExtensionProperty;
import com.guet.match.model.CmsContestGroup;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/3/19
 * @Type： 返回信息
 * @Description: 完整赛事信息 DTO = 赛事信息 + 分组信息 + 拓展属性值 + 主办方名称 + 分类名称
 */
public class ContestInfoDTO extends CmsContest {

    private String organizerName;

    private String cateName;

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

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public String toString() {
        return "ContestInfoDTO{" +
                "organizerName='" + organizerName + '\'' +
                ", cateName='" + cateName + '\'' +
                ", groupList=" + groupList +
                ", extensionPropertyList=" + extensionPropertyList +
                '}';
    }
}
