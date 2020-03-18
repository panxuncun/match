package com.guet.match.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

public class CmsContest {

    @ApiModelProperty(hidden = true)
    private Long id;

    private Long organizerId;

    private String name;

    private String type;

    private String location;

    private String logo;

    private String banner;

    @ApiModelProperty(example = "2020-03-08 12:12:00")
    private Date openEnrollmentTime;

    @ApiModelProperty(example = "2020-03-09 12:12:00")
    private Date closeEnrollmentTime;

    @ApiModelProperty(example = "2020-03-10 12:12:00")
    private Date contestTime;

    @ApiModelProperty(hidden = true)
    private Date createTime;

    @ApiModelProperty(hidden = true)
    private Integer status;

    @ApiModelProperty(hidden = true)
    private Long lastCheckId;

    @ApiModelProperty(hidden = true)
    private Date lastCheckTime;


    @ApiModelProperty(example = "2020-03-08 12:12:00")
    private String lastCheckNote;

    private String details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Date getOpenEnrollmentTime() {
        return openEnrollmentTime;
    }

    public void setOpenEnrollmentTime(Date openEnrollmentTime) {
        this.openEnrollmentTime = openEnrollmentTime;
    }

    public Date getCloseEnrollmentTime() {
        return closeEnrollmentTime;
    }

    public void setCloseEnrollmentTime(Date closeEnrollmentTime) {
        this.closeEnrollmentTime = closeEnrollmentTime;
    }

    public Date getContestTime() {
        return contestTime;
    }

    public void setContestTime(Date contestTime) {
        this.contestTime = contestTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getLastCheckNote() {
        return lastCheckNote;
    }

    public void setLastCheckNote(String lastCheckNote) {
        this.lastCheckNote = lastCheckNote;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}