package com.guet.match.controller;

import com.guet.match.dto.CommonResult;
import com.guet.match.model.SmsTopic;
import com.guet.match.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: sefer
 * @Date: 2020/3/17
 * @Description:互动话题模块
 */

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;


    //得到话题及评论
    //todo 根据opendi查头像和昵称

    @GetMapping("topic/info/{id}")
    public CommonResult getTopic(@PathVariable Long id){
        System.out.println("===contestId==="+id);
        Map map = topicService.getTopicWithCommentById(id);
        if(map.get("topic") == null){
            return CommonResult.failed("话题不存在，可能已被删除");
        }
        return CommonResult.success(map);
    }
}
