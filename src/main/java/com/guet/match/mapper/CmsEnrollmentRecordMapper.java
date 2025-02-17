package com.guet.match.mapper;

import com.guet.match.dto.EnrollmentDTO;
import com.guet.match.model.CmsEnrollmentRecord;
import com.guet.match.model.CmsEnrollmentRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsEnrollmentRecordMapper {
    int countByExample(CmsEnrollmentRecordExample example);

    int deleteByExample(CmsEnrollmentRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsEnrollmentRecord record);

    int insertSelective(CmsEnrollmentRecord record);

    List<CmsEnrollmentRecord> selectByExample(CmsEnrollmentRecordExample example);

    CmsEnrollmentRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsEnrollmentRecord record, @Param("example") CmsEnrollmentRecordExample example);

    int updateByExample(@Param("record") CmsEnrollmentRecord record, @Param("example") CmsEnrollmentRecordExample example);

    int updateByPrimaryKeySelective(CmsEnrollmentRecord record);

    int updateByPrimaryKey(CmsEnrollmentRecord record);

    //小程序获取我的赛事
    List<EnrollmentDTO> getEnrollmentListByOpenId(@Param("openId") String  openId);

    //首页，我的赛事，正在进行，且报名审核通过
    List<EnrollmentDTO> getMyContestOfIndexPage(@Param("openId") String  openId);

    //主办方，获取报名记录 todo
    List<EnrollmentDTO> getEnrollmentListByContestId(@Param("contestId") Long  contestId);
}