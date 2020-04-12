package com.guet.match.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guet.match.common.CommonResult;
import com.guet.match.dto.SignParam;
import com.guet.match.model.UmsAdmin;
import com.guet.match.service.AdminService;
import com.guet.match.service.AuthService;
import com.guet.match.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: sefer
 * @Date: 2020/3/16
 * @Description: 登陆与授权
 */
@Api(tags = "授权")
@RestController
public class AuthController {

    Logger logger = LoggerFactory.getLogger(ContestController.class);

    @Autowired
    private AuthService authService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private AdminService adminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @ApiOperation("小程序身份验证,并返回token")
    @RequestMapping("auth/openid/{code}")
    public CommonResult getOpenId(@PathVariable("code")String code){
        Map map = authService.getAuth(code);
        if (map == null){
            return CommonResult.failed("登录失败");
        }
        return CommonResult.success(map);
    }

    @ApiOperation("测试登陆 4.11")
    @RequestMapping("user/login")
    public Map getOpenId1(){
        logger.info("=====user/login");
        String res = "{\"code\":20000,\"status\":\"success\",\"data\":{\"token\":\"test-token\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String ,String > map = null;
        try {
            map = objectMapper.readValue(res, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return map;
    }

    @ApiOperation("测试登陆token 4.11")
    @RequestMapping("user/info")
    public Map getToken1(@RequestParam String token){
        logger.info("=====user/info");
        String res = "{\"code\":200,\"status\":\"success\",\"data\":{\"roles\":[\"admin111\",\"pan\"]}}";
        //String res = "{\"code\":20000,\"message\":\"操作成功\",\"data\":{\"roles\":[\"TEST\",\"Admin\"],\"icon\":\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg\",\"menus\":[{\"id\":1,\"parentId\":0,\"createTime\":\"2020-02-02T06:50:36.000+0000\",\"title\":\"商品\",\"level\":0,\"sort\":0,\"name\":\"pms\",\"icon\":\"product\",\"hidden\":0},{\"id\":2,\"parentId\":1,\"createTime\":\"2020-02-02T06:51:50.000+0000\",\"title\":\"商品列表\",\"level\":1,\"sort\":0,\"name\":\"product\",\"icon\":\"product-list\",\"hidden\":0}],\"username\":\"admin\"}}";

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String ,String > map = null;
        try {
            map = objectMapper.readValue(res, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return map;
    }

    @ApiOperation("测试登陆token 4.11")
    @RequestMapping("user/logout")
    public Map logout(){
        logger.info("=====user/logout");
        String res = "{\"code\":200,\"status\":\"success\",\"data\":\"sucess\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String ,String > map = null;
        try {
            map = objectMapper.readValue(res, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return map;
    }

    @GetMapping("admin/list/{roleId}")
    public CommonResult getAdminListByRoleId(@PathVariable Long roleId){
        return CommonResult.success(adminService.getAdminListByRoleId(roleId));
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping("auth/login")
    public CommonResult login(@RequestBody SignParam umsAdminLoginParam) {
        logger.info("登录");
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        //拆开，postman测试的时候更方便
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取登录信息4.12")
    @RequestMapping("auth/info")
    public CommonResult getUserInfo(Principal principal) {
        logger.info("=====info");
        if(principal==null){
            logger.info("=====未授权");
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        UmsAdmin admin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", admin.getUsername());
        //注意，资源标识，对应前端的roles（用于生成动态路由）
        data.put("roles",resourceService.getResourceNameForRouter(admin.getId()));
        //data.put("icon", admin.getIcon());

        return CommonResult.success(data);
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "auth/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

}
