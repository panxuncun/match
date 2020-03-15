package com.guet.match.mapper;

import com.guet.match.model.UmsOrganizerStaff;
import com.guet.match.model.UmsOrganizerStaffExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsOrganizerStaffMapper {
    int countByExample(UmsOrganizerStaffExample example);

    int deleteByExample(UmsOrganizerStaffExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsOrganizerStaff record);

    int insertSelective(UmsOrganizerStaff record);

    List<UmsOrganizerStaff> selectByExample(UmsOrganizerStaffExample example);

    UmsOrganizerStaff selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsOrganizerStaff record, @Param("example") UmsOrganizerStaffExample example);

    int updateByExample(@Param("record") UmsOrganizerStaff record, @Param("example") UmsOrganizerStaffExample example);

    int updateByPrimaryKeySelective(UmsOrganizerStaff record);

    int updateByPrimaryKey(UmsOrganizerStaff record);
}