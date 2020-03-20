package com.guet.match.service;

import com.guet.match.common.ContestStatus;
import com.guet.match.common.EnrollmentDto;
import com.guet.match.dto.ContestCheckDto;
import com.guet.match.dto.ContestDto;
import com.guet.match.mapper.*;
import com.guet.match.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;

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

    //查看赛事by id
    public ContestDto getContestInfo(Long id) {
        logger.info("查看赛事详细信息");
        return contestMapper.getContestDtoByid(id);
    }


    //insert contest
    @Transactional(rollbackFor = Exception.class)
    public boolean insertContest(ContestDto dto) {
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
    public int checkContest(ContestCheckDto dto) {
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
    public boolean updateContest(ContestDto dto) {
        try {
            long id = dto.getId();
            CmsContest contest = new CmsContest();
            BeanUtils.copyProperties(dto, contest);
            contest.setStatus(ContestStatus.WAIT.getStatus());
            contestMapper.updateByPrimaryKey(contest);
            //clean all group and list
            groupMapper.deleteByContestId(id);
            extensionPropertyMapper.deleteByContestId(id);
            //set contestId
            dto.getGroupList().stream().forEach(item -> item.setContestId(id));
            dto.getExtensionPropertyList().stream().forEach(item -> item.setContestId(id));
            //insert
            groupMapper.insertList(dto.getGroupList());
            extensionPropertyMapper.insertList(dto.getExtensionPropertyList());
            logger.info("更新赛事");
            return true;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("更新赛事失败，参数为" + dto.toString());
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
        CmsFavorite selectData = favoriteMapper.getFavorite(favorite);
        if (selectData == null) {
            logger.info("已收藏");
            return favoriteMapper.insert(favorite);
        } else {
            logger.info("已取消");
            return favoriteMapper.deleteByPrimaryKey(selectData.getId());
        }
    }

    //enrollment 0-fail; 1->success; 2->repeat
    public int insertEnrollment(EnrollmentDto dto) {
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
        enrollmentRecordMapper.insert(record);
        return 0;
    }


}
