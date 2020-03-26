package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.dto.CheckContestParam;
import com.guet.match.dto.ContestInfoDTO;
import com.guet.match.model.CmsFavorite;
import com.guet.match.service.ContestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @ApiOperation("收藏赛事")
    @PostMapping("contest/favorite")
    public CommonResult FavoriteSwitch(@RequestBody CmsFavorite favorite) {
        return contestService.favoriteSwitch(favorite) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }




    @ApiOperation("赛事删除标记")
    @PostMapping("contest/enrollment/delete/{id}")
    public CommonResult deleteEnrollment(@PathVariable long id) {
        return contestService.deleteEnrollment(id) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }
}
