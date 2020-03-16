package com.guet.match.mapper;

import com.guet.match.model.UmsRoleResource;
import com.guet.match.model.UmsRoleResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsRoleResourceMapper {
    int countByExample(UmsRoleResourceExample example);

    int deleteByExample(UmsRoleResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsRoleResource record);

    int insertSelective(UmsRoleResource record);

    List<UmsRoleResource> selectByExample(UmsRoleResourceExample example);

    UmsRoleResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsRoleResource record, @Param("example") UmsRoleResourceExample example);

    int updateByExample(@Param("record") UmsRoleResource record, @Param("example") UmsRoleResourceExample example);

    int updateByPrimaryKeySelective(UmsRoleResource record);

    int updateByPrimaryKey(UmsRoleResource record);
}