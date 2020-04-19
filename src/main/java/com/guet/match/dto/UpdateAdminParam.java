package com.guet.match.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/4/19
 * @Description: 更新管理员信息。特征是有id，且没有密码。
 */
public class UpdateAdminParam {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("管理员姓名")
    private String nickName;

    @ApiModelProperty("管理员账号")
    private String username;

    @ApiModelProperty("是否启用")
    private Integer status;

    //实质上这个属性也用不到
    @ApiModelProperty("角色")
    private List<Long> roleIds;

    @ApiModelProperty("备注")
    private String note;

    @Override
    public String toString() {
        return "UpdateAdminParam{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", roleIds=" + roleIds +
                ", note='" + note + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
