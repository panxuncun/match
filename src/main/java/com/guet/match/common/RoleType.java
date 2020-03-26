package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 角色类型
 */
public enum RoleType {
    ADMIN(1, "内管系统"),
    ORGANIZER(2, "主办方系统");

    private int type;
    private String description;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private RoleType(int status, String description) {
        this.type = status;
        this.description = description;
    }
}
