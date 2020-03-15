package com.guet.match.service;

import com.guet.match.mapper.SmsTopicMapper;
import com.guet.match.model.SmsTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/3/15
 * @Description:
 */
@Service
public class SmsService {
    @Autowired
    private SmsTopicMapper topicMapper;

    public SmsTopic getATopic(){
        return topicMapper.selectByPrimaryKey(9L);
    }

    public SmsTopic getATopicById(Long id){
        return topicMapper.selectByPrimaryKey(id);
    }

    public Long insertTopic(SmsTopic smsTopic){
        topicMapper.insertSelective(smsTopic);
        return smsTopic.getId();
    }
}
