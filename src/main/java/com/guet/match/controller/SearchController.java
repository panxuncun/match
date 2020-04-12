package com.guet.match.controller;

import com.guet.match.common.CommonPage;
import com.guet.match.common.CommonResult;
import com.guet.match.model.CmsContest;
import com.guet.match.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/3/28
 * @Description:
 */
@Controller
@Api(tags = "搜索")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @ApiOperation(value = "导入所有赛事到ES")
    @GetMapping(value = "search/import")
    @ResponseBody
    public CommonResult<Integer> importAllList() {
        int count = searchService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除赛事")
    @GetMapping(value = "search/delete/{id}")
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        searchService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id批量删除赛事")
    @GetMapping(value = "search/delete/batch")
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        searchService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id创建赛事")
    @GetMapping(value = "search/create/{id}")
    @ResponseBody
    public CommonResult<CmsContest> create(@PathVariable Long id) {
        CmsContest esProduct = searchService.create(id);
        if (esProduct != null) {
            return CommonResult.success(esProduct);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "搜索")
    @GetMapping(value = "search/contest")
    @ResponseBody
    public CommonResult search(@RequestParam String keyword,
                               @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(required = false,  defaultValue = "5") Integer pageSize) {
        List<CmsContest> list = searchService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }

}