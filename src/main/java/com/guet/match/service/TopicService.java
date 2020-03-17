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

    //得到一条话题及其回复by话题id
    public Map getTopicWithCommentById(Long id){
        Map map = new HashMap();
        map.put("topic",topicMapper.selectByPrimaryKey(id));
        map.put("commentList", topicMapper.selectCommentListByTopic(id));
        return map;
    }
}
