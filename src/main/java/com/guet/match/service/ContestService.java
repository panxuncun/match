package com.guet.match.service;

import com.github.pagehelper.PageHelper;
import com.guet.match.common.*;
import com.guet.match.dto.*;
import com.guet.match.mapper.*;
import com.guet.match.model.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
     *
     * @param
     * @return 主办方id
     */
    public Long getOrganizerId(Principal principal) {
        UmsOrganizer organizer = organizeService.getOrganizerByUsername(principal.getName());
        return organizer.getId();
    }

    //查看赛事by id
    public ContestInfoDTO getContestInfo(Long id) {
        logger.info("查看赛事详细信息");
        return contestMapper.getContestDtoByid(id);
    }

    //主办方：查看我举办的赛事
    public List<CmsContest> getContestByOrganizer(Principal principal, Integer pageNum, Integer pageSize) {
        CmsContestExample example = new CmsContestExample();
        example.setOrderByClause("id desc");
        example.createCriteria().andOrganizerIdEqualTo(getOrganizerId(principal));
        PageHelper.startPage(pageNum, pageSize);
        return contestMapper.selectByExample(example);
    }


    /**
     * 主办方：查看指定赛事下的报名记录
     *
     * @param principal 凭证
     * @param contestId 赛事id
     * @param pageNum   分页数据
     * @param pageSize  分页数据
     * @return 报名记录 List<EnrollmentDTO>
     */
    public CommonResult getEnrollmentByContestId(Principal principal, Long contestId, Integer pageNum, Integer pageSize) {
        CmsContest contest = contestMapper.selectByPrimaryKey(contestId);
        if (contest == null) {
            return CommonResult.failed("不存在的赛事");
        }
        //判断赛事所属主办方
        if (contest.getOrganizerId() != getOrganizerId(principal)) {
            return CommonResult.forbidden("你没有权限");
        }
        //获取数据
        PageHelper.startPage(pageNum, pageSize);
        List<EnrollmentDTO> list = enrollmentRecordMapper.getEnrollmentListByContestId(contestId);
        return CommonResult.success(CommonPage.restPage(list));
    }


    //主办方：导出成绩模板（所有的报名记录）
    public HSSFWorkbook exportEnrollmentByContestId(Long contestId) throws Exception {
        //拿到 pojo 数据
        CmsContest contest = contestMapper.selectByPrimaryKey(contestId);
        if (contest == null) {
            logger.error("不存在的赛事");
            return null;
        }
        String contestName = contest.getName();
        List<EnrollmentDTO> list = enrollmentRecordMapper.getEnrollmentListByContestId(contestId);


        //新建 excel 文件
        HSSFWorkbook excel = new HSSFWorkbook();
        //新建 sheet
        HSSFSheet sheet = excel.createSheet("enrollment");


        /**
         //首行: 合并单元格.弃用。因为表头会影响前端预览。
         CellRangeAddress cra = new CellRangeAddress(0, 0, 0, 9);
         sheet.addMergedRegion(cra);
         Row row = sheet.createRow(0);
         Cell mergeCell = row.createCell(0);
         mergeCell.setCellValue("注意：请按照模板格式填入内容，请勿删除模板中的任何内容。你可以对内容区域进行排序。数据将以序列号为标准录入。");
         mergeCell.setCellStyle(excel.getCellStyleAt(0));*/


        //标题（首行）
        String[] title = {"赛事", "组别", "序列号", "运动员", "号码牌", "证件号", "完赛情况", "量化成绩", "组内名次", "获奖项"};
        HSSFRow headRow = sheet.createRow(0);
        for (int i = 0; i < title.length; i++) {
            HSSFCell cell = headRow.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(title[i]);
            cell.setCellValue(text);
        }

        //填充到表格
        for (int i = 0; i < list.size(); i++) {
            EnrollmentDTO enrollment = list.get(i);
            //新建一行
            HSSFRow dataRow = sheet.createRow(i + 1);
            //填充数据
            dataRow.createCell(0).setCellValue(contestName);
            dataRow.createCell(1).setCellValue(enrollment.getGroupName());
            dataRow.createCell(2).setCellValue(String.valueOf(enrollment.getId()));
            dataRow.createCell(3).setCellValue(enrollment.getContestantRealName());
            dataRow.createCell(4).setCellValue(enrollment.getContestantNumber());
            dataRow.createCell(5).setCellValue(enrollment.getContestantIdCard());
            dataRow.createCell(6).setCellValue(enrollment.getContestantStatus());
            dataRow.createCell(7).setCellValue(enrollment.getContestantAchievement());
            dataRow.createCell(8).setCellValue(enrollment.getContestantRank());
            dataRow.createCell(9).setCellValue(enrollment.getContestantAward());
        }

        //自动列宽
        for (int i = 0; i < title.length; i++) {
            sheet.autoSizeColumn(i);
            sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 2);
        }
        return excel;
    }

    //主办方：导入成绩表格
    public CommonResult importEnrollmentByContestId(MultipartFile file, Long contestId) {
        //todo 判断序列号是否属于这个赛事
        //todo 统计行数是否一致
        //当前读取的行号，从第2行开始读取
        int i = 1;
        //错误摘要
        String errMsg = "";
        try {
            String lowerCaseFileName = file.getOriginalFilename().toLowerCase();
            if (lowerCaseFileName.endsWith(".xlsx")) {
                logger.info("office 2007");
                //XSSFWorkbook excel = new XSSFWorkbook(file.getInputStream());
                //不支持的格式
                return CommonResult.failed("不支持的格式");
            }

            logger.info("开始读取表格");
            //拿到表格
            HSSFWorkbook excel = new HSSFWorkbook(file.getInputStream());
            //拿到sheet
            HSSFSheet sheet = (HSSFSheet) excel.getSheetAt(0);
            //总行数
            int total = sheet.getLastRowNum() + 1;


            for (i = 1; i < total; i++) {
                HSSFRow row = sheet.getRow(i);
                CmsEnrollmentRecord record = new CmsEnrollmentRecord();


                //格式极易出错，原因是可能位数字,所以一定要强转为字符串
                for (int j = 2; j <= 9; j++) {
                    row.getCell(j).setCellType(CellType.STRING);
                }

                logger.info("=====3.。");

                errMsg = "序列号";
                logger.info("=====preid");

                Long id = Long.valueOf(row.getCell(2).getStringCellValue());
                logger.info("=====id{}", id);
                if (id == null) {
                    throw new Exception();
                }
                record.setId(id);

                logger.info("即将更新的记录：enrollmentId->{}", id);

                errMsg = "完赛情况";
                record.setContestantStatus(row.getCell(6).getStringCellValue());

                errMsg = "量化成绩";
                record.setContestantAchievement(row.getCell(7).getStringCellValue());

                errMsg = "名次";
                String s = row.getCell(8).getStringCellValue();
                record.setContestantRank(s);


                errMsg = "获奖项";
                record.setContestantAward(row.getCell(9).getStringCellValue());

                if (enrollmentRecordMapper.updateByPrimaryKeySelective(record) == 0) {
                    errMsg = "原因： 1.序列号可能不存在，请勿改动模板中的序列号。\n   2.序列号";
                    throw new Exception();
                }
                logger.info("更新完成：enrollmentId->{}", id);
                errMsg = "附近可能存在空行。空行";
            }
            logger.info("全部插入完毕");
            return CommonResult.success(null);
        } catch (Exception e) {
            errMsg = "导入错误: 第" + (i + 1) + "行" + errMsg + "不合法，请保证是文本格式。并且长度50字内。";
            logger.info("{}", errMsg);
            return CommonResult.failed(errMsg);
        }
    }


    /**
     * 小程序：查看我的赛事（以报名记录为准）
     *
     * @param openId
     * @param pageNum
     * @param pageSize
     * @return
     */
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
            //dto.getExtensionPropertyList().stream().forEach(item -> item.setContestId(id));
            groupMapper.insertList(dto.getGroupList());
            //extensionPropertyMapper.insertList(dto.getExtensionPropertyList());
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
    public CommonResult updateContest(ContestInfoDTO dto, Principal principal) {
        long contestId = dto.getId();
        CmsContest contest = contestMapper.selectByPrimaryKey(contestId);
        //判断赛事所属主办方
        if (contest.getOrganizerId() != getOrganizerId(principal)) {
            logger.error("拒绝赛事更新请求，原因：赛事不属于该主办方，原始参数: {}", dto.toString());
            return CommonResult.forbidden("你没有权限");
        }
        //开始更新操作
        try {
            //CmsContest contest = new CmsContest();
            BeanUtils.copyProperties(dto, contest);
            contest.setStatus(ContestStatus.WAIT.getStatus());
            //注意，这里会出现更新无效的情况，因为存在空值可能性
            contestMapper.updateByPrimaryKeySelective(contest);
            //清空之后插入，注意：0长数组会导致插入失败
            groupMapper.deleteByContestId(contestId);
            dto.getGroupList().stream().forEach(item -> item.setContestId(contestId));
            groupMapper.insertList(dto.getGroupList());

            //extensionPropertyMapper.deleteByContestId(contestId);
            //dto.getExtensionPropertyList().stream().forEach(item -> item.setContestId(contestId));
            //extensionPropertyMapper.insertList(dto.getExtensionPropertyList());
            logger.info("更新赛事成功，原始参数: {}", dto.toString());
            return CommonResult.success(null);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("更新赛事失败，原始参数: {}", dto.toString());
            return CommonResult.failed("更新失败");
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
    public List<CmsContest> filterContest(String typeName, Integer sortCode, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        CmsContestExample example = new CmsContestExample();
        //类型为空，返回所有数据
        if (typeName == null) {
            example.createCriteria();
            return contestMapper.selectByExample(example);
        }

        logger.info("原始参数：sortCode{}", sortCode);

        //设置排序
        example.setOrderByClause(SortCode.getSqlBySortType(sortCode));
        //添加条件
        //CmsContestExample.Criteria criteria = example.createCriteria().andTypeEqualTo(typeName);
        CmsContestExample.Criteria criteria = example.createCriteria();
        if (sortCode == SortCode.CLOSE_ENROLLMENT_TIME.getCode()) {
            //截止报名时间大于此刻
            criteria.andCloseEnrollmentTimeGreaterThan(new Date());
        } else if (sortCode == SortCode.CONTEST_TIME.getCode()) {
            //比赛开始时间大于此刻
            criteria.andContestTimeGreaterThan(new Date());
        }
        return contestMapper.selectByExample(example);
    }

    //管理员：获取所有赛事
    public CommonResult list(QueryContestParam param,Integer pageNum, Integer pageSize){
        CmsContestExample example = new CmsContestExample();
        CmsContestExample.Criteria criteria = example.createCriteria();
        if (param.getId() != null){
            //这里return得了
            criteria.andIdEqualTo(param.getId());
        }

        if (param.getCate() != null) {
            criteria.andCateIdEqualTo(param.getCate());
        }

        if (param.getKeyword()!=null){
            criteria.andNameLike("%" + param.getKeyword() + "%");
        }

        if (param.getStatus() != null) {
            criteria.andStatusEqualTo(param.getStatus());
        }

        PageHelper.startPage(pageNum, pageSize);
        List<CmsContest> list = contestMapper.selectByExample(example);
        return CommonResult.success(CommonPage.restPage(list));
    }

}
