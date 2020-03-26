package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 更新主办方员工状态所需参数
 */
public class UpdateStaffStatusParam {
    //主办方员工id
    private Long id;

    //目标状态
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
