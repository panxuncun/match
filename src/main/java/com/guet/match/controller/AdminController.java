package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.dto.SignParam;
import com.guet.match.model.UmsAdmin;
import com.guet.match.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description:
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @GetMapping("admin/list/{roleId}")
    public CommonResult getAdminListByRoleId(@PathVariable Long roleId){
        return CommonResult.success(adminService.getAdminListByRoleId(roleId));
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping("/login")
    public CommonResult login(@RequestBody SignParam umsAdminLoginParam) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }


}
