package com.guet.match.mapper;

import com.guet.match.model.SmsTopic;
import com.guet.match.model.SmsTopicExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SmsTopicMapper {
    int countByExample(SmsTopicExample example);

    int deleteByExample(SmsTopicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsTopic record);

    int insertSelective(SmsTopic record);

    List<SmsTopic> selectByExample(SmsTopicExample example);

    SmsTopic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsTopic record, @Param("example") SmsTopicExample example);

    int updateByExample(@Param("record") SmsTopic record, @Param("example") SmsTopicExample example);

    int updateByPrimaryKeySelective(SmsTopic record);

    int updateByPrimaryKey(SmsTopic record);
}