package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.model.CmsContestCate;
import com.guet.match.service.CateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: sefer
 * @Date: 2020/4/22
 * @Description: 赛事种类控制器
 */

@Api(tags = "赛事种类")
@RestController
public class CateController {
    @Autowired
    private CateService cateService;

    @ApiOperation("添加种类")
    @PostMapping("contest/cate/add")
    public CommonResult addCate(@RequestBody CmsContestCate cate) {
        return cateService.addCate(cate);
    }

    @ApiOperation("获取所有种类带子分类")
    @GetMapping("contest/cate/listWithChildren")
    public CommonResult getListWithChildren(){
        return cateService.getListWithChildren();
    }

    @ApiOperation("获取所有二级种类,不需要分页")
    @GetMapping("contest/cate/list")
    public CommonResult getList() {
        return cateService.getList();
    }

    @ApiOperation("获取所有一级种类")
    @GetMapping("contest/cate/parentList")
    public CommonResult getParentList() {
        return cateService.getParentList();
    }

    @ApiOperation("获取二级种类by 一级种类")
    @GetMapping("contest/cate/listByParent/{parentId}")
    public CommonResult getListByParent(@PathVariable Long parentId){
        return cateService.getListByParent(parentId);
    }

    @ApiOperation("更新种类(限制由前端负责)")
    @PostMapping("contest/cate/update")
    public CommonResult updateCate(@RequestBody CmsContestCate cate){
        return cateService.updateCate(cate);
    }

    @ApiOperation("删除种类")
    @PostMapping("contest/cate/delete/{parentId}")
    public CommonResult deleteCate(@PathVariable Long parentId){
        return cateService.deleteCate(parentId);
    }
}
