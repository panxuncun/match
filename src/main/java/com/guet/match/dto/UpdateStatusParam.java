package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 更新状态所需参数。这是一个公共DTO。被多个 service 引用。
 */
public class UpdateStatusParam {
    //目标id
    private Long id;

    //目标状态
    private int status;

    @Override
    public String toString() {
        return "UpdateStatusParam{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }

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
