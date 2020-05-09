package com.guet.match.mapper;

import com.guet.match.model.CmsRecommend;
import com.guet.match.model.CmsRecommendExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsRecommendMapper {
    int countByExample(CmsRecommendExample example);

    int deleteByExample(CmsRecommendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsRecommend record);

    int insertSelective(CmsRecommend record);

    List<CmsRecommend> selectByExample(CmsRecommendExample example);

    CmsRecommend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsRecommend record, @Param("example") CmsRecommendExample example);

    int updateByExample(@Param("record") CmsRecommend record, @Param("example") CmsRecommendExample example);

    int updateByPrimaryKeySelective(CmsRecommend record);

    int updateByPrimaryKey(CmsRecommend record);
}