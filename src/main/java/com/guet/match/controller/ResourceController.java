package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.dto.AddResourceParam;
import com.guet.match.dto.UpdateResourceParam;
import com.guet.match.model.UmsResource;
import com.guet.match.service.ResourceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/3/29
 * @Description: 资源控制器
 */
@RestController
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @ApiOperation("添加资源")
    @PostMapping("resource/add")
    public CommonResult addResource(@RequestBody AddResourceParam param) {
        return resourceService.addResource(param) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("获取资源by id")
    @GetMapping("resource/info/{id}")
    public CommonResult getResource(@PathVariable Long id){
        return CommonResult.success(resourceService.getResource(id));
    }

    @ApiOperation("获取资源列表 by 类型")
    @GetMapping("resource/list/{type}")
    public CommonResult getResourceListByType(@PathVariable Integer type){
        return CommonResult.success(resourceService.getResourceListByType(type));
    }

    @ApiOperation("更新资源")
    @PostMapping("resource/update")
    public CommonResult updateResource(@RequestBody UpdateResourceParam param) {
        return resourceService.updateResource(param) == 1? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("删除资源 by id")
    @PostMapping("resource/delete/{id}")
    public CommonResult deleteResource(Long id){
        return resourceService.deleteResource(id) == 1? CommonResult.success(null) : CommonResult.failed();
    }
}
