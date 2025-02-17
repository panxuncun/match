package com.guet.match.controller;

import com.guet.match.common.CommonPage;
import com.guet.match.common.CommonResult;
import com.guet.match.dto.*;
import com.guet.match.model.CmsContest;
import com.guet.match.model.CmsFavorite;
import com.guet.match.service.ContestService;
import com.guet.match.service.CountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * @Auther: sefer
 * @Date: 2020/3/18
 * @Description: 赛事模块控制类
 */

@Api(tags = "赛事")
@RestController
public class ContestController {
    Logger logger = LoggerFactory.getLogger(ContestController.class);

    @Autowired
    private ContestService contestService;

    @Autowired
    private CountService countService;

    //todo 前端处理一下默认分组
    @ApiOperation("添加赛事")
    @PostMapping("contest/add")
    public CommonResult addContest(@RequestBody ContestInfoDTO dto) {
        return contestService.insertContest(dto) ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("单个审核赛事")
    @PreAuthorize("hasAuthority('contest:check')")
    @PostMapping("contest/check")
    public CommonResult checkContest(@RequestBody CheckContestParam dto) {
        return contestService.checkContest(dto) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("主办方：单个或批量审核报名")
    @PreAuthorize("hasAuthority('contest:check')")
    @PostMapping("contest/enrollment/check")
    public CommonResult checkContest(@RequestBody CheckParam param) {
        return contestService.checkEnrollment(param);
    }

    @ApiOperation("批量审核赛事")
    @PostMapping("contest/batchCheck")
    public CommonResult batchCheckContest(@RequestBody CheckParam param){
        return contestService.batchCheckContest(param);
    }


    /**
     * 批量退款。涉及到记录和订单，由记录调用订单方法.
     *
     * @param ids 报名ids
     * @return CommonResult
     */
    @ApiOperation("主办方：批量退款")
    @PostMapping("contest/enrollment/batchRefund")
    public CommonResult batchRefund(@RequestBody List<Long> ids) {
        return contestService.batchRefund(ids);
    }

    @ApiOperation("公共：查看赛事by id")
    @GetMapping("contest/info/{id}")
    public CommonResult getContestInfo(@PathVariable long id) {
        return CommonResult.success(contestService.getContestInfo(id));
    }

    @ApiOperation("管理员：获取所有赛事")
    @GetMapping("contest/list")
    public CommonResult list(QueryContestParam param,
                             @RequestParam(required = false, value = "page", defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, value = "limit", defaultValue = "5") Integer pageSize) {
        return contestService.list(param, pageNum, pageSize);
    }

    @GetMapping("contest/group/list/{contestId}")
    public CommonResult getGroupListById(@PathVariable Long contestId) {
        return contestService.getGroupListById(contestId);
    }

    @ApiOperation("主办方：管理报名")
    @GetMapping("contest/enrollment/listByQuery")
    public CommonResult listByQuery(QueryEnrollmentParam param,
                                    @RequestParam(required = false, value = "page", defaultValue = "1") Integer pageNum,
                                    @RequestParam(required = false, value = "limit", defaultValue = "5") Integer pageSize) {
        return contestService.listByQuery(param, pageNum, pageSize);
    }


    @ApiOperation("主办方：查看我举办的赛事")
    @GetMapping("contest/listByOrganizer")
    public CommonResult getContestByOrganizer(Principal principal,
                                              @RequestParam(required = false, value = "page", defaultValue = "1") Integer pageNum,
                                              @RequestParam(required = false, value = "limit", defaultValue = "5") Integer pageSize) {
        if (principal == null) {
            logger.info("主办方：查看我举办的赛事->未授权");
            return CommonResult.unauthorized(null);
        }
        List<CmsContest> list = contestService.getContestByOrganizer(principal, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("主办方：查看指定赛事下的报名记录")
    @GetMapping("contest/enrollment/listByContestId")
    public CommonResult getEnrollmentByContestId(Principal principal,
                                                 @RequestParam(required = true) Long contestId,
                                                 @RequestParam(required = false, value = "page", defaultValue = "1") Integer pageNum,
                                                 @RequestParam(required = false, value = "limit", defaultValue = "5") Integer pageSize) {
        if (principal == null) {
            logger.info("主办方：查看指定赛事下的报名记录->未授权");
            return CommonResult.unauthorized(null);
        }
        return contestService.getEnrollmentByContestId(principal, contestId, pageNum, pageSize);
    }

    @ApiOperation("主办方：导出成绩模板")
    @GetMapping("contest/enrollment/export/{contestId}")
    public void exportEnrollmentByContestId(HttpServletResponse response, @PathVariable Long contestId) {
        logger.info("下载请求：导出成绩模板");
        try {
            HSSFWorkbook excel = contestService.exportEnrollmentByContestId(contestId);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=enrollment.xls");
            response.flushBuffer();
            excel.write(response.getOutputStream());
        } catch (Exception e) {
            logger.error("导出excel文件出错, 传入参数contestId->{}", contestId);
        }
    }

    @ApiOperation("首页，我的赛事，正在进行，且报名审核通过")
    @GetMapping("contest/listMyContest/{openId}")
    public CommonResult getMyContestOfIndexPage(@PathVariable String openId){
        return contestService.getMyContestOfIndexPage(openId);
    }

    @ApiOperation("主办方：导入成绩表格")
    @PostMapping("contest/enrollment/import/{contestId}")
    public CommonResult importEnrollmentByContestId(Principal principal,@RequestParam(value = "file") MultipartFile file, @PathVariable Long contestId) {
        logger.info("导入成绩表格,contestId->{}", contestId);
        return contestService.importEnrollmentByContestId(principal,file, contestId);
    }


    @ApiOperation("小程序：查看赛事记录by openId")
    @GetMapping("contest/enrollment/list")
    public CommonResult getEnrollmentByOpenId(@RequestParam(required = true) String openId,
                                              @RequestParam(required = false, value = "pageNum", defaultValue = "1") Integer pageNum,
                                              @RequestParam(required = false, value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<EnrollmentDTO> list = contestService.getEnrollmentByOpenId(openId, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("筛选赛事")
    @PostMapping("contest/filter")
    public CommonResult filterContest(@RequestBody FilterParam param) {
        logger.info("filter请求参数->{}",param.toString());
        List<CmsContest> list = contestService.filterContest(param.getCateIds(), param.getSortCode(), param.getPageNum(), param.getPageSize());
        return CommonResult.success(CommonPage.restPage(list));
    }


    @ApiOperation("删除报名记录delete flag")
    @PostMapping("contest/enrollment/delete")
    public CommonResult deleteEnrollment(@RequestBody Map<String, Long> map) {
        return contestService.deleteEnrollment(map.get("id")) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("更新赛事")
    @PostMapping("contest/update")
    public CommonResult updateContest(@RequestBody ContestInfoDTO dto, Principal principal) {
        return contestService.updateContest(dto, principal);
    }

    @ApiOperation("删除赛事标记")
    @PostMapping("contest/delete/{id}")
    public CommonResult deleteContestFlag(@PathVariable long id) {
        return contestService.deleteContestFlag(id) == 1 ? CommonResult.success(null) : CommonResult.failed("操作失败，赛事不存在");
    }


    @ApiOperation("收藏赛事、取消收藏")
    @PostMapping("contest/favorite/add")
    public CommonResult addFavorite(@RequestBody CmsFavorite favorite) {
        logger.info("=====controller" + favorite.getContestId() + favorite.getOpenId());
        return contestService.favoriteSwitch(favorite) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("收藏赛事、取消收藏")
    @PostMapping("contest/favorite/delete")
    public CommonResult deleteFavorite(@RequestBody CmsFavorite favorite) {
        return contestService.favoriteSwitch(favorite) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    //返回1是收藏 0是未收藏
    @ApiOperation("查询是否收藏")
    @GetMapping("contest/favorite/pend")
    public CommonResult isFavorite(@RequestParam String openId, @RequestParam Long contestId) {
        logger.info("====={}", openId);
        logger.info("====={}", contestId);
        return CommonResult.success(contestService.isFavorite(openId, contestId));
    }


    @ApiOperation("查询收藏")
    @GetMapping("contest/favorite/list")
    public CommonResult getFavorite(@RequestParam(required = true) String openId,
                                    @RequestParam(required = false, value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(required = false, value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<CmsContest> list = contestService.getFavorite(openId, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("统计：报名情况")
    @GetMapping("contest/count/enrollmentArr")
    public CommonResult countEnrollment(Principal principal,@RequestParam Integer day){
        return countService.countEnrollment(principal,day);
    }

    @ApiOperation("生成号码牌")
    @PostMapping("contest/createConstantNumber/{contestId}")
    public CommonResult createConstantNumber(@PathVariable Long contestId){
        return contestService.createConstantNumber(contestId);
    }

    @ApiOperation("取消赛事")
    @PostMapping("contest/cancel/{contestId}")
    public CommonResult cancelContest(@PathVariable Long contestId){
        return contestService.cancelContest(contestId);
    }



}
