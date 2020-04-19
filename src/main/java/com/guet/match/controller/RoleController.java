package com.guet.match.controller;

import com.guet.match.common.CommonPage;
import com.guet.match.common.CommonResult;
import com.guet.match.dto.AddRoleParam;
import com.guet.match.dto.AllocParam;
import com.guet.match.dto.UpdateRoleParam;
import com.guet.match.dto.UpdateStatusParam;
import com.guet.match.model.UmsAdmin;
import com.guet.match.model.UmsRole;
import com.guet.match.service.ResourceService;
import com.guet.match.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 角色控制器
 */
@Api(tags = "角色")
@RestController
public class RoleController {

    Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceService resourceService;

    @ApiOperation("获取全部角色, 分页")
    @GetMapping("role/list")
    public CommonResult listAllRole(@RequestParam(required = false, defaultValue = "") String keyword,
                                    @RequestParam(required = false, value = "page", defaultValue = "1") Integer pageNum,
                                    @RequestParam(required = false, value = "limit", defaultValue = "5") Integer pageSize) {
        List<UmsRole> list = roleService.listAllRole(keyword,pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("获取全部角色by admin")
    @GetMapping("role/listByAdmin/{adminId}")
    public CommonResult listByAdmin(@PathVariable Long adminId){
        return CommonResult.success(roleService.listByAdmin(adminId));
    }


    //添加角色(内管系统角色)
    @PostMapping("role/add")
    public CommonResult addRole(@RequestBody AddRoleParam param) {
        return roleService.addRole(param) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("更新角色")
    @PostMapping("role/update")
    public CommonResult updateRole(@RequestBody UpdateRoleParam param){
        return roleService.updateRole(param) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }


    @ApiOperation("更新角色状态")
    @PostMapping("role/updateStatus")
    public CommonResult updateRoleStatus(@RequestBody UpdateStatusParam param) {
        return roleService.updateRoleStatus(param) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("为角色分配资源")
    @PostMapping("role/allocResource")
    public CommonResult allocResource(@RequestBody AllocParam param) {
        return resourceService.allocResource(param);
    }

    @ApiOperation("删除角色 by id")
    @PostMapping("role/delete/{roleId}")
    public CommonResult deleteRole(@PathVariable Long roleId){
        return roleService.deleteRole(roleId) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

}
