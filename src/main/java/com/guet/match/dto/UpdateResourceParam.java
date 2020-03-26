package com.guet.match.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 更细资源信息所需的参数
 */
public class UpdateResourceParam {
    @ApiModelProperty("资源id")
    private Long id;

    @ApiModelProperty("资源名称")
    private String name;

    @ApiModelProperty("父资源id")
    private Long parentId;

    @ApiModelProperty("资源类型")
    private Integer type;

    @ApiModelProperty("资源url")
    private String url;

    @ApiModelProperty("资源权限标识")
    private String permission;

    @ApiModelProperty("资源对应前端组件")
    private String component;

    @ApiModelProperty("资源描述")
    private String description;

    @ApiModelProperty("资源图标")
    private String icon;

    @ApiModelProperty("资源排序")
    private Integer sort;

    @ApiModelProperty("资源状态")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
