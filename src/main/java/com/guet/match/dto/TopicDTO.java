package com.guet.match.dto;

import com.guet.match.model.SmsTopic;
import com.guet.match.model.UmsConstant;

/**
 * @Auther: sefer
 * @Date: 2020/3/17
 * @Description: 互动话题信息 DTO = 话题信息 + 发布者信息，发布者即微信小程序用户
 */
public class TopicDTO extends SmsTopic {

    //昵称动态更新
    private String nickName;
    //头像动态更新
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
