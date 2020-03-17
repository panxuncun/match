package com.guet.match.service;

import com.guet.match.mapper.SmsTopicMapper;
import com.guet.match.model.SmsTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: sefer
 * @Date: 2020/3/17
 * @Description:TopicService
 */
@Service
public class TopicService {
    @Autowired
    private SmsTopicMapper topicMapper;

    //todo 要校验删的是不是自己的 topic

    //得到指定赛事下的话题
    public List<SmsTopic> getTopicList(Long contestId){
        return topicMapper.selectTopicList(contestId);
    }


    //得到一条话题(包含回复)
    public Map getTopicWithComment(Long topicId){
        Map map = new HashMap();
        System.out.println(111);
        map.put("topic",topicMapper.selectTopicDto(topicId));
        map.put("commentList", topicMapper.selectCommentList(topicId));
        return map;
    }

    //删除一条话题或回复
    public int deleteTopicOrComment(Long topicId){
        return topicMapper.deleteTopicOrComment(topicId);
    }

    //新建话题
    public Long insertTopic(SmsTopic topic){
        topic.setParentId(0L);
        return topicMapper.insertSelective(topic);
    }


    //回复话题
    public Long insertComment(SmsTopic topic){
        return topicMapper.insertSelective(topic);
    }

}
