package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.model.SmsTopic;
import com.guet.match.service.TopicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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


    @ApiOperation("获取指定赛事下的话题列表")
    @GetMapping("topic/list/{contestId}")
    public CommonResult getTopicList(@PathVariable Long contestId) {
        List<SmsTopic> list = topicService.getTopicList(contestId);
        return list == null ? CommonResult.failed() : CommonResult.success(list);
    }


    @ApiOperation("获取话题详情（包含评论")
    @GetMapping("topic/info/{topicId}")
    public CommonResult getTopic(@PathVariable Long topicId) {
        System.out.println("===contestId===" + topicId);
        Map map = topicService.getTopicWithComment(topicId);
        if (map.get("topic") == null) {
            return CommonResult.failed("话题不存在，可能已被删除");
        }
        return CommonResult.success(map);
    }


    @ApiOperation("新建话题，不需要 parentId")
    @PostMapping("topic/add")
    public CommonResult insertTopic(@RequestBody SmsTopic topic) {
        return topicService.insertTopic(topic) == 0 ? CommonResult.failed() : CommonResult.success(null);
    }


    @ApiOperation("回复指定话题，需要提供 parentId")
    @PostMapping("topic/comment/add")
    public CommonResult insertComment(@RequestBody SmsTopic topic) {
        return topicService.insertComment(topic) == 0 ? CommonResult.failed() : CommonResult.success(null);
    }


    @ApiOperation("删除指定话题")
    @PostMapping("topic/delete/{id}")
    public CommonResult deleteTopicOrComment(@PathVariable Long id) {
        return topicService.deleteTopicOrComment(id) == 0 ? CommonResult.failed() : CommonResult.success(null);
    }


    @ApiOperation("删除指定回复")
    @PostMapping("topic/comment/delete/{id}")
    public CommonResult deletComment(@PathVariable Long id) {
        return topicService.deleteTopicOrComment(id) == 0 ? CommonResult.failed() : CommonResult.success(null);
    }


}
