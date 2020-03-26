package com.guet.match.mapper;

import com.guet.match.model.UmsRoleAdmin;
import com.guet.match.model.UmsRoleAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsRoleAdminMapper {
    int countByExample(UmsRoleAdminExample example);

    int deleteByExample(UmsRoleAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsRoleAdmin record);

    int insertSelective(UmsRoleAdmin record);

    List<UmsRoleAdmin> selectByExample(UmsRoleAdminExample example);

    UmsRoleAdmin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsRoleAdmin record, @Param("example") UmsRoleAdminExample example);

    int updateByExample(@Param("record") UmsRoleAdmin record, @Param("example") UmsRoleAdminExample example);

    int updateByPrimaryKeySelective(UmsRoleAdmin record);

    int updateByPrimaryKey(UmsRoleAdmin record);
}