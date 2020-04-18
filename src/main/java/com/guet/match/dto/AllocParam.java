package com.guet.match.dto;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/4/18
 * @Description: 分配权限所需参数：例如分配角色、分配资源。这是一个公共DTO。被多个 service 引用。
 */
public class AllocParam {
    //目标id
    private Long id;

    //配置项ids
    private List<Long> ids;

    @Override
    public String toString() {
        return "AllocParam{" +
                "id=" + id +
                ", ids=" + ids +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
