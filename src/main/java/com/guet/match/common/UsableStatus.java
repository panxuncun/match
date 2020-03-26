package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 可用状态
 */
public enum UsableStatus {
    ON(0, "已停用"),
    OFF(1, "已启用"),
    DELETE_FLAG(2, "删除标记");

    private int status;
    private String description;

    private UsableStatus(int status, String description) {
        this.status = status;
        this.description = description;

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String  getDescriptionByStatus(int status) {
        for (UsableStatus s:values()){
            if (status == s.status){
                return s.description;
            }
        }
        return null;
    }
}
