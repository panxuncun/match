package com.guet.match.service;

import com.guet.match.dto.ContestDto;
import com.guet.match.mapper.CmsContestExtensionPropertyMapper;
import com.guet.match.mapper.CmsContestGroupMapper;
import com.guet.match.mapper.CmsContestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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

    @Transactional(rollbackFor = Exception.class)
    public boolean insertContest(ContestDto dto) {
        try {
            contestMapper.insert(dto.getContest());
            Long contestId = dto.getContest().getId();
            //set contestId
            dto.getGroupList().stream().forEach(item -> item.setContestId(contestId));
            dto.getExtensionPropertyList().stream().forEach(item -> item.setContestId(contestId));
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
}
