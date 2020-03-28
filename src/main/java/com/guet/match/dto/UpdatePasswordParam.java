package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/3/27
 * @Description: 修改密码所需参数。这是一个公共DTO。被多个 service 引用。
 */
public class UpdatePasswordParam {
    //目标id
    private Long id;

    //目标密码
    private String password;

    @Override
    public String toString() {
        return "UpdatePasswordParam{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

