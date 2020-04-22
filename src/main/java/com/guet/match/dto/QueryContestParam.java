package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/4/23
 * @Description: 管理员查询赛事所需参数
 */
public class QueryContestParam {

    //赛事id
    private Long id;

    //关键词
    private String keyword;

    //状态
    private Integer status;

    //分类
    private Long cate;

    @Override
    public String toString() {
        return "QueryContestParam{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", status=" + status +
                ", cate=" + cate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCate() {
        return cate;
    }

    public void setCate(Long cate) {
        this.cate = cate;
    }
}
