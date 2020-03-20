package com.guet.match.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class CmsFavorite {
    @ApiModelProperty(hidden = true)
    private Long id;

    private Long contestId;

    private String openId;

    @ApiModelProperty(hidden = true)
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}