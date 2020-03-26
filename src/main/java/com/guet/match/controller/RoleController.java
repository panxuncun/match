package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.dto.AddRoleParam;
import com.guet.match.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 角色控制器
 */
@Api(tags = "角色")
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    //添加角色(内管系统角色)
    @PostMapping("role/add")
    public CommonResult addRole(@RequestBody AddRoleParam param) {
        return roleService.addRole(param) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }
}
