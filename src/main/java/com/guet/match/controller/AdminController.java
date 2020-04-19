package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.dto.*;
import com.guet.match.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @Auther: sefer
 * @Date: 2020/4/19
 * @Description: 系统管理员控制器
 */
@Api(tags = "系统管理员")
@RestController
public class AdminController {
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @ApiOperation("获取全部管理员")
    @GetMapping("admin/list")
    public CommonResult getAdminList(@RequestParam(required = false) String keyword,
                                     @RequestParam(required = false, value = "page", defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, value = "limit", defaultValue = "5") Integer pageSize) {
        return adminService.getAdminList(keyword, pageNum, pageSize);
    }

    @ApiOperation("更新管理员")
    @PostMapping("admin/update")
    public CommonResult updateAdmin(@RequestBody UpdateAdminParam param) {
        return adminService.updateAdmin(param);
    }

    @ApiOperation("更新管理员状态")
    @PostMapping("admin/updateStatus")
    public CommonResult updateAdminStatus(@RequestBody UpdateStatusParam param){
        return adminService.updateAdminStatus(param) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("重置密码")
    @PostMapping("admin/updatePassword")
    public CommonResult updatePassword(@RequestBody UpdatePasswordParam param) {
        return adminService.updatePassword(param);
    }

    @ApiOperation("删除管理员")
    @PostMapping("admin/delete/{adminId}")
    public CommonResult deleteAdmin(Principal principal, @PathVariable Long adminId){
        return adminService.deleteAdmin(principal,adminId);
    }

    @ApiOperation("添加管理员")
    @PostMapping("admin/add")
    public CommonResult addAdmin(@RequestBody AddAdminParam param){
        return adminService.addAdmin(param);
    }
    
    @ApiOperation("为用户分配角色")
    @PostMapping("admin/allocRole")
    public CommonResult allocRole(@RequestBody AllocParam param){
        return adminService.allocRole(param);
    }



}
