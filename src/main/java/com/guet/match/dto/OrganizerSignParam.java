package com.guet.match.dto;

import java.util.Date;

/**
 * @Auther: sefer
 * @Date: 2020/5/25
 * @Description: 主办方注册参数
 */
public class OrganizerSignParam {

    private String username;

    private String password;

    private String organizerName;

    @Override
    public String toString() {
        return "OrganizerSignParam{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", organizerName='" + organizerName + '\'' +
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

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }
}
