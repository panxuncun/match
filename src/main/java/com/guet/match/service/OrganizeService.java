package com.guet.match.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.guet.match.common.CommonResult;
import com.guet.match.common.OrganizerStatus;
import com.guet.match.dto.BatchAddStaffDto;
import com.guet.match.dto.OrganizerApplyDto;
import com.guet.match.dto.OrganizerCheckDto;
import com.guet.match.dto.SignDto;
import com.guet.match.mapper.CmsContestMapper;
import com.guet.match.mapper.UmsOrganizerMapper;
import com.guet.match.mapper.UmsOrganizerStaffMapper;
import com.guet.match.model.*;
import com.guet.match.util.OSSUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * @Auther: sefer
 * @Date: 2020/3/25
 * @Description: 主办方相关
 */
@Service
public class OrganizeService {

    Logger logger = LoggerFactory.getLogger(OrganizeService.class);
    final int MIN_BATCH_COUNT = 1; //一次批量生成账号的最小数目
    final int MAX_BATCH_COUNT = 20; //一次批量生成账号的最大数目
    final int MAX_TOTAL = 35; //最大账号总数
    final int INIT = OrganizerStatus.INIT.getStatus();//初始态
    final int WAIT_FOR_CHECK = OrganizerStatus.WAIT.getStatus();//等待审核
    final int PASS = OrganizerStatus.PASS.getStatus();//审核通过
    final int REFUSE = OrganizerStatus.REFUSE.getStatus();//审核未通过
    final int OFF = OrganizerStatus.OFF.getStatus();//停用
    final int DELETE_FLAG = OrganizerStatus.DELETE_FLAG.getStatus();//删除标记

    @Autowired
    private UmsOrganizerMapper organizerMapper;

    @Autowired
    private CmsContestMapper contestMapper;

    @Autowired
    private UmsOrganizerStaffMapper staffMapper;

    //账号查重
    public boolean isDuplicate(String username) {
        UmsOrganizerExample example = new UmsOrganizerExample();
        example.createCriteria().andUsernameEqualTo(username);
        if (organizerMapper.selectByExample(example).size() > 0) {
            return true;
        }
        return false;
    }

    //注册主办方账号
    @Transactional
    public int sign(SignDto dto) {
        UmsOrganizer organizer = new UmsOrganizer();
        if (isDuplicate(dto.getUsername())) {
            logger.info("账号已注册{}", dto.getUsername());
            return 2;
        }
        try {
            logger.info("用户注册{}", dto.toString());
            BeanUtils.copyProperties(dto, organizer);
            //注册后置为初始态
            organizer.setStatus(INIT);
            organizer.setCreateTime(new Date());
            return organizerMapper.insert(organizer);
        } catch (Exception e) {
            logger.error("无法插入主办方注册信息{}", dto.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    //更新主办方资料
    @Transactional
    public int update(OrganizerApplyDto dto, MultipartFile file[]) {
        UmsOrganizer organizer = organizerMapper.selectByPrimaryKey(dto.getId());
        if (organizer == null) {
            return 0;
        }

        //清空之前的图片(传入一个字符串数组，数组内容为要删除的文件名)
        OSSUtil.deleteByArr(organizer.getIdentityDocument().split("\\,"));
        //上传新的图片到OSS,全部成功则返回文件名数组 urlArr
        String[] fileNameArr = OSSUtil.uploadByArr(file);
        if (fileNameArr != null && fileNameArr.length > 0) {
            organizer.setIdentityDocument(String.join(",", fileNameArr));
        }

        BeanUtils.copyProperties(dto, organizer);
        //状态为等待审核（每一次更新资料都要审核）
        organizer.setStatus(OrganizerStatus.WAIT.getStatus());
        //更新数据
        try {
            return organizerMapper.updateByPrimaryKey(organizer);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    //获取符合条件的主办方list
    public List<UmsOrganizer> getOrganizerList(Integer status) {
        if (status == null) {
            return null;
        }
        UmsOrganizerExample example = new UmsOrganizerExample();
        example.createCriteria().andStatusEqualTo(status);
        return organizerMapper.selectByExample(example);
    }

    //获取指定主办方信息
    public UmsOrganizer getOrganizerById(Long id) {
        if (id == null) {
            return null;
        }
        return organizerMapper.selectByPrimaryKey(id);
    }

    //审核、停用、删除
    public CommonResult changeStatus(OrganizerCheckDto dto) {
        Map map = new HashMap<Integer, String>();
        UmsOrganizer organizer = organizerMapper.selectByPrimaryKey(dto.getId());
        if (organizer == null) {
            logger.error("不存在的主办方, id->{}", dto.getId());
            return CommonResult.failed("不存在的主办方");
        }

        //pass为【通过】
        //试图【停用】、【未通过】、【删除】主办方，需要进一步检查是否有正在进行的比赛
        if (dto.getStatus() != PASS) {
            CmsContestExample example = new CmsContestExample();
            example.createCriteria().andOrganizerIdEqualTo(dto.getId());
            if (contestMapper.selectByExample(example).size() > 0) {
                return CommonResult.failed("该主办方有正在进行的比赛, 暂时无法停用。进行本操作前必须停止所有该主办方的比赛。");
            }
        }
        BeanUtils.copyProperties(dto, organizer);
        if (organizerMapper.updateByPrimaryKey(organizer) == 0) {
            logger.error("无法更新主办方状态, id->{}", dto.getId());
            return CommonResult.failed("系统错误");
        }
        return CommonResult.success(null);
    }


    //申请成为主办方
    public CommonResult applyForOrganizer(Long id) {
        if (id == null) {
            return CommonResult.failed("未指定主办方");
        }
        UmsOrganizer organizer = organizerMapper.selectByPrimaryKey(id);
        if (organizer == null) {
            logger.error("不存在的主办方, id->{}", id);
            return CommonResult.failed("不存在的主办方");
        }

        //只有初始态的可以提交申请
        if (organizer.getStatus() != INIT) {
            return CommonResult.failed("主办方状态不满足");
        }

        organizer.setStatus(WAIT_FOR_CHECK);
        return organizerMapper.updateByPrimaryKey(organizer) == 1 ? CommonResult.success(null) : CommonResult.failed();

    }


    //批量生成账号
    @Transactional
    public CommonResult batchAdd(BatchAddStaffDto dto) {
        int targetCount = dto.getCount();
        if (targetCount > MAX_BATCH_COUNT || targetCount < MIN_BATCH_COUNT) {
            return CommonResult.failed("指定的数量不合法, 请输入介于[" + MIN_BATCH_COUNT + "," + MAX_BATCH_COUNT + "]的数量");
        }
        UmsOrganizerStaffExample example = new UmsOrganizerStaffExample();
        example.createCriteria().andContestIdEqualTo(dto.getContestId());
        //该比赛下可用数量 = 最大总量 - 现有账号数量
        int availableCount = MAX_TOTAL - staffMapper.selectByExample(example).size();
        if (availableCount < targetCount) {
            return CommonResult.failed("当前赛事下，最多还可生成账号" + availableCount + "个");
        }
        //开始生成
        List<UmsOrganizerStaff> list = new LinkedList<>();
        try {
            for (int i = 0; i < targetCount; i++) {
                UmsOrganizerStaff staff = new UmsOrganizerStaff();
                staff.setContestId(dto.getContestId());
                staff.setUsername(UUID.randomUUID().toString().replace("-", ""));
                staff.setPassword(UUID.randomUUID().toString().replace("-", ""));
                staff.setRole(dto.getRole());
                staffMapper.insert(staff);
                list.add(staff);
            }
            return CommonResult.success(list);
        } catch (Exception e) {
            logger.error("无法插入主办方工作人员账号, 原始请求信息{}", dto.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return CommonResult.failed("系统错误，请重试");

    }

}
