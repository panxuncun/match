package com.guet.match.mapper;

import com.guet.match.model.CmsContest;
import com.guet.match.model.CmsContestExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsContestMapper {
    int countByExample(CmsContestExample example);

    int deleteByExample(CmsContestExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsContest record);

    int insertSelective(CmsContest record);

    List<CmsContest> selectByExampleWithBLOBs(CmsContestExample example);

    List<CmsContest> selectByExample(CmsContestExample example);

    CmsContest selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsContest record, @Param("example") CmsContestExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsContest record, @Param("example") CmsContestExample example);

    int updateByExample(@Param("record") CmsContest record, @Param("example") CmsContestExample example);

    int updateByPrimaryKeySelective(CmsContest record);

    int updateByPrimaryKeyWithBLOBs(CmsContest record);

    int updateByPrimaryKey(CmsContest record);
}