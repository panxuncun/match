package com.guet.match.controller;

import com.guet.match.dto.CommonResult;
import com.guet.match.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: sefer
 * @Date: 2020/3/16
 * @Description:
 */
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    //小程序请求身份验证，测试openid：olNo_5YB07zojzStjgfdQ5tElZKU
    @RequestMapping("auth/openid/{code}")
    public CommonResult getOpenId(@PathVariable("code")String code){
        Map map = authService.getAuth(code);
        if (map == null){
            return CommonResult.failed("登录失败");
        }
        return CommonResult.success(map);
    }

}
