package com.guet.match.controller;

import com.guet.match.common.CommonPage;
import com.guet.match.common.CommonResult;
import com.guet.match.dto.CheckContestParam;
import com.guet.match.dto.ContestInfoDTO;
import com.guet.match.dto.EnrollmentDTO;
import com.guet.match.dto.FilterContestParam;
import com.guet.match.model.CmsContest;
import com.guet.match.model.CmsFavorite;
import com.guet.match.service.ContestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("查看赛事by id")
    @GetMapping("contest/info/{id}")
    public CommonResult getContestInfo(@PathVariable long id) {
        return CommonResult.success(contestService.getContestInfo(id));
    }

    @ApiOperation("查看赛事记录by openId")
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
        List<CmsContest> list = contestService.filterContest(typeName,sortCode, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }


    @ApiOperation("删除报名记录delete flag")
    @PostMapping("contest/enrollment/delete")
    public CommonResult deleteEnrollment(@RequestBody Map<String, Long> map) {
        return contestService.deleteEnrollment(map.get("id")) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("更新赛事")
    @PostMapping("contest/update")
    public CommonResult updateContest(@RequestBody ContestInfoDTO dto) {
        return contestService.updateContest(dto) ? CommonResult.success(null) : CommonResult.failed();
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
