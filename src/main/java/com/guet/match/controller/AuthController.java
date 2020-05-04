package com.guet.match.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guet.match.common.CommonResult;
import com.guet.match.dto.SignParam;
import com.guet.match.mapper.UmsOrganizerMapper;
import com.guet.match.model.UmsAdmin;
import com.guet.match.model.UmsOrganizer;
import com.guet.match.model.UmsOrganizerExample;
import com.guet.match.service.AdminService;
import com.guet.match.service.AuthService;
import com.guet.match.service.OrganizeService;
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

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UmsOrganizerMapper organizerMapper;

    @Autowired
    private AdminService adminService;

    @Autowired
    private OrganizeService organizeService;

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

    @GetMapping("admin/list/{roleId}")
    public CommonResult getAdminListByRoleId(@PathVariable Long roleId){
        return CommonResult.success(adminService.getAdminListByRoleId(roleId));
    }

    //不开放这个接口
    @ApiOperation(value = "系统管理员:注册")
    @RequestMapping(value = "admin/auth/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            CommonResult.failed("用户名已存在");
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "系统管理员:登录")
    @PostMapping("auth/admin/login")
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

    @ApiOperation("系统管理员:获取权限+用户信息")
    @GetMapping("auth/admin/info")
    public CommonResult getUserInfo(Principal principal) {
        logger.info("=====info");
        if(principal==null){
            logger.info("=====未授权");
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        UmsAdmin admin = adminService.getAdminByUsername(username);
        Map<String, Object> map = new HashMap<>();
        map.put("username", admin.getUsername());
        map.put("userId", admin.getId());
        //注意，资源标识，对应前端的roles（用于生成动态路由）
        map.put("roles",resourceService.getResourceNameForRouter(admin.getId()));
        //map.put("icon", admin.getIcon());
        return CommonResult.success(map);
    }

    @ApiOperation(value = "主办方:登录")
    @PostMapping("auth/organizer/login")
    public CommonResult organizeLogin(@RequestBody SignParam param) {
        String token = organizeService.login(param.getUsername(), param.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        //拆开，postman测试的时候更方便
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }


    @ApiOperation("主办方：获取权限+用户信息")
    @GetMapping("auth/organizer/info")
    public CommonResult getOrganizeInfo(Principal principal) {
        logger.info("主办方来请求角色，准备返回organizer");
        if(principal==null){
            logger.info("未授权");
            return CommonResult.failed("登录失败，无法获取主办方信息");
        }
        String username = principal.getName();
        UmsOrganizer organizer = organizeService.getOrganizerByUsername(username);
        if (organizer == null){
            return CommonResult.failed("登录失败，不存在的主办方");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("username", organizer.getUsername());
        map.put("userId", organizer.getId());
        //注意，资源标识，对应前端的roles（用于生成动态路由）
        map.put("roles",new String[]{"organizer"});
        return CommonResult.success(map);
    }

    @ApiOperation("公用info")
    @GetMapping("auth/info")
    public CommonResult commonInfo(Principal principal) {
        logger.info("主办方来请求角色，准备返回organizer");
        if(principal==null){
            logger.info("未授权");
            return CommonResult.failed("登录失败，无法获取主办方信息");
        }
        String username = principal.getName();
        Map<String, Object> map = new HashMap<>();

        //-----
        UmsOrganizer organizer = organizeService.getOrganizerByUsername(username);
        if (organizer != null){
            map.put("username", organizer.getUsername());
            map.put("userId", organizer.getId());
            //注意，资源标识，对应前端的roles（用于生成动态路由）
            map.put("roles",new String[]{"organizer"});
            return CommonResult.success(map);
        }
        //-----

        UmsAdmin admin = adminService.getAdminByUsername(username);
        if (admin != null){
            map.put("username", admin.getUsername());
            map.put("userId", admin.getId());
            map.put("roles",resourceService.getResourceNameForRouter(admin.getId()));
            return CommonResult.success(map);
        }
        return CommonResult.failed("无法获取用户权限信息");

    }


    @ApiOperation("公用：登出")
    @PostMapping("auth/logout")
    public CommonResult logout(Principal principal) {
        return CommonResult.success(null);
    }






}
