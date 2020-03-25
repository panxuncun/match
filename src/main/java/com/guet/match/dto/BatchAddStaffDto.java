package com.guet.match.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 批量生成主办方工作人员账号所需参数
 */
public class BatchAddStaffDto {

    @ApiModelProperty("所属赛事id")
    private Long contestId;

    @ApiModelProperty("角色")
    private String role;

    @ApiModelProperty("生成账号的数量")
    private int count;

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BatchAddStaffDto{" +
                "contestId=" + contestId +
                ", role='" + role + '\'' +
                ", count=" + count +
                '}';
    }
}
