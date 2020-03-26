package com.guet.match.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 添加管理员所需参数
 */
public class AddAdminParam {

    @ApiModelProperty("管理员账号")
    private String username;

    @ApiModelProperty("管理员密码")
    private String password;

    @ApiModelProperty("角色")
    private long[] roleIds;

    @Override
    public String toString() {
        return "AddAdminParam{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleIds=" + Arrays.toString(roleIds) +
                '}';
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

    public long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(long[] roleIds) {
        this.roleIds = roleIds;
    }
}
