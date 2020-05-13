package com.guet.match.service;

import com.github.pagehelper.PageHelper;
import com.guet.match.dto.TopicDTO;
import com.guet.match.mapper.SmsTopicMapper;
import com.guet.match.model.SmsTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: sefer
 * @Date: 2020/3/17
 * @Description: TopicService
 */
@Service
public class TopicService {
    Logger logger = LoggerFactory.getLogger(TopicService.class);
    @Autowired
    private SmsTopicMapper topicMapper;

    //todo 要校验删的是不是自己的 topic

    //得到指定赛事下的话题（根话题）
    public List<TopicDTO> getTopicList(Long contestId, Integer pageNum, Integer pageSize){
        if (contestId == null){
            return new ArrayList<>();
        }
        PageHelper.startPage(pageNum, pageSize);
        return topicMapper.selectTopicList(contestId);
    }


    //得到一条话题(包含回复)
    //@PreAuthorize("hasAuthority('pms:brand:read')")
    public Map getTopicWithComment(Long topicId){
        logger.info("=====查看topic->{}",topicId);
        Map map = new HashMap();
        map.put("topic",topicMapper.selectTopicDto(topicId));
        map.put("commentList", topicMapper.selectCommentList(topicId));
        return map;
    }

    //得到话题下的回复 4.7
    //topicId即parent_id
    public List<TopicDTO> getCommentList(Long topicId, Integer pageNum, Integer pageSize){
        if (topicId == null){
            return new ArrayList<>();
        }
        PageHelper.startPage(pageNum, pageSize);
        return topicMapper.selectCommentList(topicId);
    }


    //删除一条话题或回复
    public int deleteTopicOrComment(Long topicId){
        return topicMapper.deleteTopicOrComment(topicId);
    }

    //新建话题
    public Long insertTopic(SmsTopic topic){
        logger.info("插入主题->{}",topic.toString());
        topic.setParentId(0L);
        return topicMapper.insertSelective(topic);
    }


    //回复话题
    public Long insertComment(SmsTopic topic){
        return topicMapper.insertSelective(topic);
    }

}
