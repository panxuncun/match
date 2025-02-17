package com.guet.match.dto;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/4/30
 * @Description: 公共DTO，审核报名或者审核报名所需参数
 */
public class CheckParam {
    //ids
    private List<Long> ids;
    //目标状态
    private Integer status;

    @Override
    public String toString() {
        return "CheckParam{" +
                "ids=" + ids +
                ", status=" + status +
                '}';
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
