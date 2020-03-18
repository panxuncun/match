package com.guet.match.mapper;

import com.guet.match.model.CmsContestExtensionProperty;
import com.guet.match.model.CmsContestExtensionPropertyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsContestExtensionPropertyMapper {
    int countByExample(CmsContestExtensionPropertyExample example);

    int deleteByExample(CmsContestExtensionPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsContestExtensionProperty record);

    //insert List
    int insertList(List<CmsContestExtensionProperty> list);

    int insertSelective(CmsContestExtensionProperty record);

    List<CmsContestExtensionProperty> selectByExample(CmsContestExtensionPropertyExample example);

    CmsContestExtensionProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsContestExtensionProperty record, @Param("example") CmsContestExtensionPropertyExample example);

    int updateByExample(@Param("record") CmsContestExtensionProperty record, @Param("example") CmsContestExtensionPropertyExample example);

    int updateByPrimaryKeySelective(CmsContestExtensionProperty record);

    int updateByPrimaryKey(CmsContestExtensionProperty record);
}