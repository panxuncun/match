package com.guet.match.mapper;

import com.guet.match.model.CmsContestGroup;
import com.guet.match.model.CmsContestGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsContestGroupMapper {
    int countByExample(CmsContestGroupExample example);

    int deleteByExample(CmsContestGroupExample example);

    int deleteByPrimaryKey(Long id);

    //delete by contest_id
    int deleteByContestId(Long id);

    int insert(CmsContestGroup record);

    //insert List
    int insertList(List<CmsContestGroup> list);

    int insertSelective(CmsContestGroup record);

    List<CmsContestGroup> selectByExample(CmsContestGroupExample example);


    CmsContestGroup selectByPrimaryKey(Long id);

    //getGroupListByContestId
    List<CmsContestGroup> getGroupListByContestId(Long id);

    int updateByExampleSelective(@Param("record") CmsContestGroup record, @Param("example") CmsContestGroupExample example);

    int updateByExample(@Param("record") CmsContestGroup record, @Param("example") CmsContestGroupExample example);

    int updateByPrimaryKeySelective(CmsContestGroup record);

    int updateByPrimaryKey(CmsContestGroup record);

    //剩余容量-1
    int sizeMinus(Long id);

    //剩余容量+1
    int sizePlus(Long id);

    //获取剩余容量
    public int getUsableSize(Long id);
}