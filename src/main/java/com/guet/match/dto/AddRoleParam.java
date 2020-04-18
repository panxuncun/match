package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 添加角色所需参数
 */
public class AddRoleParam {
    private String tag;

    private String name;

    private String description;

    private Long adminId;

    private Integer status;

    @Override
    public String toString() {
        return "AddRoleParam{" +
                "tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", adminId=" + adminId +
                ", status=" + status +
                '}';
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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
