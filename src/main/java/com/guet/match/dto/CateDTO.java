package com.guet.match.dto;

import com.guet.match.model.CmsContestCate;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/4/22
 * @Description: 赛事分类DTO，带子分类
 */
public class CateDTO extends CmsContestCate {

    //子分类
    List<CmsContestCate> children;

    @Override
    public String toString() {
        return "CateDTO{" +
                "children=" + children +
                '}';
    }

    public List<CmsContestCate> getChildren() {
        return children;
    }

    public void setChildren(List<CmsContestCate> children) {
        this.children = children;
    }
}
