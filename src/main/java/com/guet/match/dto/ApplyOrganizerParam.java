package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/3/25
 * @Description: 主办方申请认证需要的参数
 */
public class ApplyOrganizerParam {
    private Long id;

    private String adminName;

    private String adminIdCard;

    private String organizerName;

    private Integer organizerType;

    private String organizerCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminIdCard() {
        return adminIdCard;
    }

    public void setAdminIdCard(String adminIdCard) {
        this.adminIdCard = adminIdCard;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public Integer getOrganizerType() {
        return organizerType;
    }

    public void setOrganizerType(Integer organizerType) {
        this.organizerType = organizerType;
    }

    public String getOrganizerCode() {
        return organizerCode;
    }

    public void setOrganizerCode(String organizerCode) {
        this.organizerCode = organizerCode;
    }

}
