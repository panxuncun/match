package com.guet.match.dto;

import io.swagger.annotations.ApiModelProperty;


/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 添加资源所需参数
 */
public class AddResourceParam {


    @ApiModelProperty("资源名字")
    private String name;

    @ApiModelProperty("父资源id")
    private Long parentId;

    @ApiModelProperty("资源类型")
    private int type;

    @ApiModelProperty("url")
    private String url;

    @ApiModelProperty("权限标识")
    private String permission;

    @ApiModelProperty("对应前端组件")
    private String component;

    @ApiModelProperty("详细描述")
    private String description;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("创建人id")
    private Long adminId;

    @Override
    public String toString() {
        return "AddResourceParam{" +
                "name='" + name + '\'' +
                ", parentId=" + parentId +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", component='" + component + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", sort=" + sort +
                ", adminId=" + adminId +
                '}';
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
