package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.dto.ContestDto;
import com.guet.match.service.ContestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: sefer
 * @Date: 2020/3/18
 * @Description:赛事模块控制类
 */

@RestController
public class ContestController {
    @Autowired
    private ContestService contestService;

    @ApiOperation("添加赛事")
    @PostMapping("contest/add")
    public CommonResult addContest(@RequestBody ContestDto dto){
        return contestService.insertContest(dto)?CommonResult.success(null):CommonResult.failed();
    }
}
