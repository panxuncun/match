package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 资源类别：1->菜单；2->接口; 3->按钮
 */
public enum ResourceType {
    MEUN(1,"菜单"),
    API(2,"接口"),
    BUTTON(3,"按钮");

    private int type;
    private String description;

    private ResourceType(int status, String description) {
        this.type = status;
        this.description = description;
    }

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
}
