package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: sefer
 * @Date: 2020/3/16
 * @Description:
 */
@Api(tags = "授权")
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;


    @ApiOperation("小程序身份验证,并返回token")
    @RequestMapping("auth/openid/{code}")
    public CommonResult getOpenId(@PathVariable("code")String code){
        Map map = authService.getAuth(code);
        if (map == null){
            return CommonResult.failed("登录失败");
        }
        return CommonResult.success(map);
    }

}
