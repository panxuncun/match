package com.guet.match.controller;

import com.guet.match.common.CommonPage;
import com.guet.match.common.CommonResult;
import com.guet.match.dto.CheckContestParam;
import com.guet.match.dto.ContestInfoDTO;
import com.guet.match.dto.EnrollmentDTO;
import com.guet.match.model.CmsContest;
import com.guet.match.model.CmsFavorite;
import com.guet.match.service.ContestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    //todo 前端处理一下默认分组
    @ApiOperation("添加赛事")
    @PostMapping("contest/add")
    public CommonResult addContest(@RequestBody ContestInfoDTO dto) {
        return contestService.insertContest(dto) ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("审核赛事")
    @PostMapping("contest/check")
    public CommonResult checkContest(@RequestBody CheckContestParam dto) {
        return contestService.checkContest(dto) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("公共：查看赛事by id")
    @GetMapping("contest/info/{id}")
    public CommonResult getContestInfo(@PathVariable long id) {
        return CommonResult.success(contestService.getContestInfo(id));
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
    public void exportEnrollmentByContestId(HttpServletResponse response, @PathVariable Long contestId){
        logger.info("下载请求：导出成绩模板");
        try {
            HSSFWorkbook excel = contestService.exportEnrollmentByContestId(contestId);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=enrollment.xls");
            response.flushBuffer();
            excel.write(response.getOutputStream());
        } catch (Exception e) {
            logger.error("导出excel文件出错, 传入参数contestId->{}",contestId);
        }
    }

    @ApiOperation("主办方：导入成绩表格")
    @PostMapping("contest/enrollment/import/{contestId}")
    public CommonResult importEnrollmentByContestId(@RequestParam(value = "file") MultipartFile file, @PathVariable Long contestId){
        logger.info("导入成绩表格,contestId->{}",contestId);
        return contestService.importEnrollmentByContestId(file, contestId);
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
    @GetMapping("contest/filter")
    public CommonResult filterContest(@RequestParam(required = false) String typeName,
                                      @RequestParam(required = true, defaultValue = "0") Integer sortCode,
                                      @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        List<CmsContest> list = contestService.filterContest(typeName, sortCode, pageNum, pageSize);
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

}
