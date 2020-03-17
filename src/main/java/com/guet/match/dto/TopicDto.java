package com.guet.match.dto;

import com.guet.match.model.SmsTopic;
import com.guet.match.model.UmsConstant;

/**
 * @Auther: sefer
 * @Date: 2020/3/17
 * @Description:话题 = 话题信息 + 发布者信息，发布者即微信小程序用户
 */
public class TopicDto extends SmsTopic {

    //昵称
    private String nickName;
    //头像
    private String avatarUrl;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
