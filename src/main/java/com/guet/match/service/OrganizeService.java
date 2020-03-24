package com.guet.match.service;

import com.guet.match.dto.SignDto;
import com.guet.match.mapper.UmsOrganizerMapper;
import com.guet.match.model.UmsOrganizer;
import com.guet.match.model.UmsOrganizerExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @Auther: sefer
 * @Date: 2020/3/25
 * @Description: 主办方相关
 */
@Service
public class OrganizeService {

    Logger logger = LoggerFactory.getLogger(OrganizeService.class);

    @Autowired
    private UmsOrganizerMapper organizerMapper;

    //账号查重
    public boolean isDuplicate(String username) {
        UmsOrganizerExample example = new UmsOrganizerExample();
        example.createCriteria().andUsernameEqualTo(username);
        if (organizerMapper.selectByExample(example).size() > 0) {
            return true;
        }
        return false;
    }

    //主办方注册
    @Transactional
    public int sign(SignDto dto) {
        UmsOrganizer organizer = new UmsOrganizer();
        if (isDuplicate(dto.getUsername())) {
            logger.info("账号已注册{}", dto.getUsername());
            return 2;
        }
        try {
            BeanUtils.copyProperties(dto, organizer);
            logger.info("用户注册{}", dto.toString());
            return organizerMapper.insert(organizer);
        } catch (Exception e) {
            logger.error("无法插入主办方注册信息{}", dto.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

}
