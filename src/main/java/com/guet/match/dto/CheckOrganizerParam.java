package com.guet.match.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Auther: sefer
 * @Date: 2020/3/25
 * @Description: 审核主办方所需参数
 */
public class CheckOrganizerParam {

    @ApiModelProperty("主办方id")
    private Long id;

    @ApiModelProperty("审核结果")
    private Integer status;

    @ApiModelProperty("最近一次审核人id")
    private Long lastCheckId;

    @ApiModelProperty("最近一次审核备注")
    private String lastCheckNote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getLastCheckId() {
        return lastCheckId;
    }

    public void setLastCheckId(Long lastCheckId) {
        this.lastCheckId = lastCheckId;
    }

    public String getLastCheckNote() {
        return lastCheckNote;
    }

    public void setLastCheckNote(String lastCheckNote) {
        this.lastCheckNote = lastCheckNote;
    }
}
