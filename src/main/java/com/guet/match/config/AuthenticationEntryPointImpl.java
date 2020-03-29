package com.guet.match.config;
import cn.hutool.json.JSONUtil;
import com.guet.match.common.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @Auther: sefer
 * @Date: 2020/3/29
 * @Description: 当未登录或者token失效访问接口时，自定义的返回结果
 * @Source： 来源：http://www.macrozheng.com/#/architect/mall_arch_04?id=%e6%b7%bb%e5%8a%a0restauthenticationentrypoint
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(CommonResult.unauthorized(authException.getMessage())));
        response.getWriter().flush();
    }
}
