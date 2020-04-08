package com.guet.match.common;

/**
 * @Auther: sefer
 * @Date: 2020/4/8
 * @Description: 排序类型
 */
public enum SortCode {
    DEFAULT(0,"id DESC","默认最新发布"),
    CONTEST_TIME(1,"contest_time ASC","即将开赛且此刻之后(明天、后天...)"),
    CLOSE_ENROLLMENT_TIME(2,"close_enrollment_time ASC","即将截止报名且此刻之后(明天、后天...)"),
    LOCATION(3, "close_enrollment_time DESC","距离最近,todo");

    private int code;
    private String sql;
    private String description;

    private SortCode(int code, String sql, String description) {
        this.code = code;
        this.sql = sql;
        this.description = description;
    }

    public static String  getSqlBySortType(int code) {
        for (SortCode s:values()){
            if (code == s.code){
                return s.sql;
            }
        }
        return DEFAULT.sql;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
