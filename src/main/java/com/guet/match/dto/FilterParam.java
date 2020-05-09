package com.guet.match.dto;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/5/4
 * @Description: 筛选赛事所需的参数
 */
public class FilterParam {
    private List<Long> cateIds;
    private Integer sortCode;
    private Integer pageNum;
    private Integer pageSize;

    @Override
    public String toString() {
        return "FilterParam{" +
                "cateIds=" + cateIds +
                ", sortCode=" + sortCode +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

    public List<Long> getCateIds() {
        return cateIds;
    }

    public void setCateIds(List<Long> cateIds) {
        this.cateIds = cateIds;
    }

    public Integer getSortCode() {
        return sortCode;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
