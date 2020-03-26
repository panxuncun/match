package com.guet.match.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 更细角色信息所需的参数
 */
public class UpdateRoleParam {
    @ApiModelProperty("角色id")
    private Long id;

    @ApiModelProperty("标记")
    private String tag;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("描述")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
