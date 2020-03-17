package com.guet.match.mapper;

import com.guet.match.dto.TopicDto;
import com.guet.match.model.SmsTopic;
import com.guet.match.model.SmsTopicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsTopicMapper {
    int countByExample(SmsTopicExample example);

    int deleteByExample(SmsTopicExample example);

    //删除话题或回复
    int deleteTopicOrComment(Long id);

    int insert(SmsTopic record);

    //int to long
    Long insertSelective(SmsTopic record);

    List<SmsTopic> selectByExample(SmsTopicExample example);

    SmsTopic selectByPrimaryKey(Long id);

    //查询话题下的评论
    List<SmsTopic> selectCommentList(Long id);

    //指定赛事下的互动话题列表
    List<SmsTopic> selectTopicList(Long id);

    int updateByExampleSelective(@Param("record") SmsTopic record, @Param("example") SmsTopicExample example);

    int updateByExample(@Param("record") SmsTopic record, @Param("example") SmsTopicExample example);

    int updateByPrimaryKeySelective(SmsTopic record);

    int updateByPrimaryKey(SmsTopic record);

    //dto
    TopicDto selectTopicDto(Long id);
}