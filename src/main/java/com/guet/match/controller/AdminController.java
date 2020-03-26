package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description:
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("admin/list/{roleId}")
    public CommonResult getAdminListByRoleId(@PathVariable Long roleId){
        return CommonResult.success(adminService.getAdminListByRoleId(roleId));
    }

}
