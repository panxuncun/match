package com.guet.match.mapper;

import com.guet.match.model.CmsContestGroup;
import com.guet.match.model.CmsContestGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsContestGroupMapper {
    int countByExample(CmsContestGroupExample example);

    int deleteByExample(CmsContestGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsContestGroup record);

    //insert List
    int insertList(List<CmsContestGroup> list);

    int insertSelective(CmsContestGroup record);

    List<CmsContestGroup> selectByExample(CmsContestGroupExample example);

    CmsContestGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsContestGroup record, @Param("example") CmsContestGroupExample example);

    int updateByExample(@Param("record") CmsContestGroup record, @Param("example") CmsContestGroupExample example);

    int updateByPrimaryKeySelective(CmsContestGroup record);

    int updateByPrimaryKey(CmsContestGroup record);
}