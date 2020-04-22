package com.guet.match.mapper;

import com.guet.match.model.CmsContestCate;
import com.guet.match.model.CmsContestCateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsContestCateMapper {
    int countByExample(CmsContestCateExample example);

    int deleteByExample(CmsContestCateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsContestCate record);

    int insertSelective(CmsContestCate record);

    List<CmsContestCate> selectByExample(CmsContestCateExample example);

    CmsContestCate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsContestCate record, @Param("example") CmsContestCateExample example);

    int updateByExample(@Param("record") CmsContestCate record, @Param("example") CmsContestCateExample example);

    int updateByPrimaryKeySelective(CmsContestCate record);

    int updateByPrimaryKey(CmsContestCate record);
}