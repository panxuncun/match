package com.guet.match.mapper;

import com.guet.match.model.UmsOrganizer;
import com.guet.match.model.UmsOrganizerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsOrganizerMapper {
    int countByExample(UmsOrganizerExample example);

    int deleteByExample(UmsOrganizerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsOrganizer record);

    int insertSelective(UmsOrganizer record);

    List<UmsOrganizer> selectByExample(UmsOrganizerExample example);

    UmsOrganizer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsOrganizer record, @Param("example") UmsOrganizerExample example);

    int updateByExample(@Param("record") UmsOrganizer record, @Param("example") UmsOrganizerExample example);

    int updateByPrimaryKeySelective(UmsOrganizer record);

    int updateByPrimaryKey(UmsOrganizer record);

    //查询机构名称(用于级联查询contestDTO)
    String getNameById(Long id);
}