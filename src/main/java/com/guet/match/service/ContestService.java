package com.guet.match.service;

import com.github.pagehelper.PageHelper;
import com.guet.match.common.CommonResult;
import com.guet.match.common.ContestStatus;
import com.guet.match.common.DeleteStatus;
import com.guet.match.common.SortCode;
import com.guet.match.dto.*;
import com.guet.match.mapper.*;
import com.guet.match.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: sefer
 * @Date: 2020/3/18
 * @Description:
 */
@Service
public class ContestService {
    Logger logger = LoggerFactory.getLogger(ContestService.class);

    @Autowired
    private CmsContestMapper contestMapper;

    @Autowired
    private CmsContestGroupMapper groupMapper;

    @Autowired
    private CmsContestExtensionPropertyMapper extensionPropertyMapper;

    @Autowired
    private CmsFavoriteMapper favoriteMapper;

    @Autowired
    private CmsEnrollmentRecordMapper enrollmentRecordMapper;

    @Autowired
    private OrganizeService organizeService;


    /**
     * 工具：获取主办方id By username
     * @param
     * @return 主办方id
     */
    public Long getOrganizerId(Principal principal){
        UmsOrganizer organizer = organizeService.getOrganizerByUsername(principal.getName());
        return organizer.getId();
    }

    //查看赛事by id
    public ContestInfoDTO getContestInfo(Long id) {
        logger.info("查看赛事详细信息");
        return contestMapper.getContestDtoByid(id);
    }

    //主办方：查看我举办的赛事
    public List<CmsContest> getContestByOrganizer(Principal principal, Integer pageNum, Integer pageSize){
        CmsContestExample example = new CmsContestExample();
        example.createCriteria().andOrganizerIdEqualTo(getOrganizerId(principal));
        PageHelper.startPage(pageNum, pageSize);
        return contestMapper.selectByExample(example);
    }

    //小程序：查看我的赛事（以报名记录为准）
    public List<EnrollmentDTO> getEnrollmentByOpenId(String openId, Integer pageNum, Integer pageSize) {
        if (openId == null) {
            return new ArrayList();
        }
        PageHelper.startPage(pageNum, pageSize);
        return enrollmentRecordMapper.getEnrollmentListByOpenId(openId);
    }

    //删除报名记录delete flag
    public int deleteEnrollment(Long id) {
        CmsEnrollmentRecord record = enrollmentRecordMapper.selectByPrimaryKey(id);
        if (record == null) {
            return 0;
        }
        //拿到比赛时间
        CmsContest contest = contestMapper.selectByPrimaryKey(record.getContestId());
        //默认ContestTime是不可能为空的
        if ((new Date()).getTime() < contest.getContestTime().getTime()) {
            logger.error("比赛->{}未开始，不允许用户删除报名记录。原始参数：id->{}", contest.getName(), id);
            return 0;
        }
        record.setStatus(DeleteStatus.DELETE_FLAG.getStatus());
        return enrollmentRecordMapper.updateByPrimaryKey(record);
    }


    //insert contest
    @Transactional(rollbackFor = Exception.class)
    public boolean insertContest(ContestInfoDTO dto) {
        try {
            CmsContest contest = new CmsContest();
            BeanUtils.copyProperties(dto, contest);
            contest.setStatus(ContestStatus.WAIT.getStatus());
            contestMapper.insert(contest);
            Long id = contest.getId();
            //set contestId
            dto.getGroupList().stream().forEach(item -> item.setContestId(id));
            dto.getExtensionPropertyList().stream().forEach(item -> item.setContestId(id));
            groupMapper.insertList(dto.getGroupList());
            extensionPropertyMapper.insertList(dto.getExtensionPropertyList());
            logger.info("插入赛事相关信息");
            return true;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("插入赛事失败，方法insertContest");
            return false;
        }

    }

    //check contest
    public int checkContest(CheckContestParam dto) {
        CmsContest contest = contestMapper.selectByPrimaryKey(dto.getContestId());
        if (contest == null) {
            logger.error("赛事不存在，方法checkContest");
            return 0;
        }
        contest.setCreateTime(new Date());
        //copy dto -> contest
        BeanUtils.copyProperties(dto, contest);
        logger.info("审核赛事");
        return contestMapper.updateByPrimaryKey(contest);
    }

    //update 更新（状态由系统变为等待审核）
    @Transactional(rollbackFor = Exception.class)
    public boolean updateContest(ContestInfoDTO dto) {
        try {
            long id = dto.getId();
            CmsContest contest = new CmsContest();
            BeanUtils.copyProperties(dto, contest);
            contest.setStatus(ContestStatus.WAIT.getStatus());
            //注意，这里会出现更新无效的情况，因为存在空值可能性
            contestMapper.updateByPrimaryKeySelective(contest);
            //clean all group and list
            groupMapper.deleteByContestId(id);
            extensionPropertyMapper.deleteByContestId(id);
            //set contestId
            dto.getGroupList().stream().forEach(item -> item.setContestId(id));
            dto.getExtensionPropertyList().stream().forEach(item -> item.setContestId(id));
            //insert
            groupMapper.insertList(dto.getGroupList());
            extensionPropertyMapper.insertList(dto.getExtensionPropertyList());
            logger.info("更新赛事成功，原始参数, id:{}",contest.getId());
            return true;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("更新赛事失败，原始参数{}",dto.toString());
            return false;
        }
    }

    //delete flag
    public int deleteContestFlag(Long id) {
        CmsContest contest = contestMapper.selectByPrimaryKey(id);
        if (contest == null) {
            return 0;
        }
        contest.setStatus(ContestStatus.DELETE_FLAG.getStatus());
        return contestMapper.updateByPrimaryKey(contest);
    }

    //favorite insert or delete
    public int favoriteSwitch(CmsFavorite favorite) {
        logger.info("Service favoriteSwitch，原始参数: openId->{}, contestId->{}", favorite.getOpenId(), favorite.getContestId());
        CmsFavorite selectData = favoriteMapper.getFavorite(favorite);
        if (selectData == null) {
            logger.info("已添加收藏，原始参数: openId->{}, contestId->{}", favorite.getOpenId(), favorite.getContestId());
            return favoriteMapper.insert(favorite);
        } else {
            logger.info("已取消收藏，原始参数: openId->{}, contestId->{}", favorite.getOpenId(), favorite.getContestId());
            return favoriteMapper.deleteByPrimaryKey(selectData.getId());
        }
    }

    //enrollment 0->fail; 1->success; 2->repeat
    public int insertEnrollment(OrderParam dto) {
        //pending repeat
        CmsEnrollmentRecordExample example = new CmsEnrollmentRecordExample();
        //BeanUtils.copyProperties(dto, example);
        example.createCriteria().andOpenIdEqualTo(dto.getOpenId()).andContestIdEqualTo(dto.getContestId()).andContestGroupIdEqualTo(dto.getContestGroupId());
        if (enrollmentRecordMapper.selectByExample(example).size() > 0) {
            logger.info("试图重复报名");
            return 2;
        }
        logger.info("报名");
        CmsEnrollmentRecord record = new CmsEnrollmentRecord();
        BeanUtils.copyProperties(dto, record);
        record.setStatus(DeleteStatus.NORMAL.getStatus());
        return enrollmentRecordMapper.insert(record);
    }


    //查询全部比赛
    public List<CmsContest> allOfContest() {
        CmsContestExample example = new CmsContestExample();
        example.createCriteria();
        return contestMapper.selectByExample(example);
    }

    //查询收藏list
    public List<CmsContest> getFavorite(String openId, int pageNum, int pageSize) {
        if (openId == null) {
            logger.error("获取收藏错误：openId->null");
            return new ArrayList<>();
        }
        //拿到收藏的赛事ids（赛事id--openId）
        CmsFavoriteExample favoriteExample = new CmsFavoriteExample();
        favoriteExample.createCriteria().andOpenIdEqualTo(openId);
        List<CmsFavorite> favoriteList = favoriteMapper.selectByExample(favoriteExample);
        if (favoriteList.size() == 0) {
            logger.info("该用户没有收藏任务赛事, 原始参数openId->{}", openId);
            return new ArrayList<>();
        }
        List<Long> ids = favoriteList.stream().map(item -> item.getContestId()).collect(Collectors.toList());
        //根据ids查询赛事
        PageHelper.startPage(pageNum, pageSize);
        CmsContestExample contestExample = new CmsContestExample();
        contestExample.createCriteria().andIdIn(ids);
        return contestMapper.selectByExample(contestExample);

    }

    //查询是否收藏
    public int isFavorite(String openId, Long contestId) {
        CmsFavoriteExample example = new CmsFavoriteExample();
        example.createCriteria().andOpenIdEqualTo(openId).andContestIdEqualTo(contestId);
        return favoriteMapper.selectByExample(example).size();
    }

    //筛选赛事(排序码依据枚举SortType)
    public List<CmsContest> filterContest(String typeName,Integer sortCode,Integer pageNum,Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        CmsContestExample example = new CmsContestExample();
        //类型为空，返回所有数据
        if (typeName == null) {
            example.createCriteria();
            return contestMapper.selectByExample(example);
        }

        logger.info("原始参数：sortCode{}",sortCode);

        //设置排序
        example.setOrderByClause(SortCode.getSqlBySortType(sortCode));
        //添加条件
        CmsContestExample.Criteria criteria = example.createCriteria().andTypeEqualTo(typeName);
        if (sortCode == SortCode.CLOSE_ENROLLMENT_TIME.getCode()){
            //截止报名时间大于此刻
            criteria.andCloseEnrollmentTimeGreaterThan(new Date());
        }else if(sortCode == SortCode.CONTEST_TIME.getCode()){
            //比赛开始时间大于此刻
            criteria.andContestTimeGreaterThan(new Date());
        }
        return contestMapper.selectByExample(example);
    }


}
