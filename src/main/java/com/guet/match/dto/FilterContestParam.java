package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/4/8
 * @Description: 筛选赛事参数
 */
public class FilterContestParam {
    //赛事类型
    private String contestTypeName;

    //排序类型（按照枚举）
    Integer sortType;

    @Override
    public String toString() {
        return "FilterContestParam{" +
                "type='" + contestTypeName + '\'' +
                ", sortType=" + sortType +
                '}';
    }

    public String getContestTypeName() {
        return contestTypeName;
    }

    public void setContestTypeName(String contestTypeName) {
        this.contestTypeName = contestTypeName;
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }
}
