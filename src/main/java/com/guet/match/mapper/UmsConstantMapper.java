package com.guet.match.mapper;

import com.guet.match.model.UmsConstant;
import com.guet.match.model.UmsConstantExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsConstantMapper {
    int countByExample(UmsConstantExample example);

    int deleteByExample(UmsConstantExample example);

    int deleteByPrimaryKey(String openId);

    int insert(UmsConstant record);

    int insertSelective(UmsConstant record);

    List<UmsConstant> selectByExample(UmsConstantExample example);

    UmsConstant selectByPrimaryKey(String openId);

    int updateByExampleSelective(@Param("record") UmsConstant record, @Param("example") UmsConstantExample example);

    int updateByExample(@Param("record") UmsConstant record, @Param("example") UmsConstantExample example);

    int updateByPrimaryKeySelective(UmsConstant record);

    int updateByPrimaryKey(UmsConstant record);
}