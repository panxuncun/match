package com.guet.match.model;

import java.util.Date;

public class UmsOrganizer {
    private Long id;

    private String username;

    private String password;

    private String openId;

    private String adminName;

    private String adminPhone;

    private String adminIdCard;

    private String organizerName;

    private Integer organizerType;

    private String organizerCode;

    private String identityDocument;

    private Integer status;

    private Long lastCheckId;

    private Date lastCheckTime;

    private Date lastCheckNote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
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

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getLastCheckId() {
        return lastCheckId;
    }

    public void setLastCheckId(Long lastCheckId) {
        this.lastCheckId = lastCheckId;
    }

    public Date getLastCheckTime() {
        return lastCheckTime;
    }

    public void setLastCheckTime(Date lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }

    public Date getLastCheckNote() {
        return lastCheckNote;
    }

    public void setLastCheckNote(Date lastCheckNote) {
        this.lastCheckNote = lastCheckNote;
    }
}