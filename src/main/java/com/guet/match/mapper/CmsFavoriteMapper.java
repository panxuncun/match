package com.guet.match.mapper;

import com.guet.match.model.CmsFavorite;
import com.guet.match.model.CmsFavoriteExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsFavoriteMapper {
    int countByExample(CmsFavoriteExample example);

    int deleteByExample(CmsFavoriteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsFavorite record);

    int insertSelective(CmsFavorite record);

    List<CmsFavorite> selectByExample(CmsFavoriteExample example);

    CmsFavorite selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsFavorite record, @Param("example") CmsFavoriteExample example);

    int updateByExample(@Param("record") CmsFavorite record, @Param("example") CmsFavoriteExample example);

    int updateByPrimaryKeySelective(CmsFavorite record);

    int updateByPrimaryKey(CmsFavorite record);
}