package com.guet.match.config;


import cn.hutool.json.JSONUtil;
import com.guet.match.common.CommonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Auther: sefer
 * @Date: 2020/3/29
 * @Description: 当访问接口没有权限时，自定义的返回结果
 * @Source: 来源：http://www.macrozheng.com/#/architect/mall_arch_04?id=%e6%b7%bb%e5%8a%a0restfulaccessdeniedhandler
 * @source: 目前有两种命名RestfulAccessDeniedHandler和RestAccessDeniedHandler
 */

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler{
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(CommonResult.forbidden(e.getMessage())));
        response.getWriter().flush();
    }
}