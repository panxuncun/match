package com.guet.match.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 添加管理员所需参数
 */
public class AddAdminParam {

    @ApiModelProperty("管理员姓名")
    private String nickName;

    @ApiModelProperty("管理员账号")
    private String username;

    @ApiModelProperty("管理员密码")
    private String password;

    @ApiModelProperty("是否启用")
    private Integer status;

    @ApiModelProperty("角色")
    private List<Long> roleIds;

    @Override
    public String toString() {
        return "AddAdminParam{" +
                "nickName='" + nickName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", roleIds=" + roleIds +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
