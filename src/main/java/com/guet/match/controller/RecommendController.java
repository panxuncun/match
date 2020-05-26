package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.model.CmsRecommend;
import com.guet.match.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: sefer
 * @Date: 2020/5/4
 * @Description: 推荐
 */
@Api(tags = "推荐")
@RestController
public class RecommendController {
    @Autowired
    private RecommendService recommendService;


    @ApiOperation("添加推荐")
    @PreAuthorize("hasAuthority('contest:recommend')")
    @PostMapping("recommend/add")
    public CommonResult addRecommend(@RequestBody CmsRecommend recommend) {
        return recommendService.addRecommend(recommend);
    }

    @ApiOperation("删除推荐")
    @PreAuthorize("hasAuthority('contest:recommend')")
    @PostMapping("recommend/delete/{id}")
    public CommonResult deleteRecommendByContestId(@PathVariable Long id) {
        return recommendService.deleteRecommendByContestId(id);
    }


    @ApiOperation("小程序：获取所有推荐（审核通过的）")
    @GetMapping("recommend/list")
    public CommonResult list() {
        return recommendService.list();
    }

    @ApiOperation("管理员，获取所有推荐（所有类型）")
    @GetMapping("recommend/listForAdmin")
    public CommonResult listForAdmin() {
        return recommendService.listForAdmin();
    }

}
