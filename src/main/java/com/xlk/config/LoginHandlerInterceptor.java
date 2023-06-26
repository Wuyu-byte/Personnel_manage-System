package com.xlk.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//拦截器
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆成功之后
        Object loginUser=request.getSession().getAttribute("loginUser");
        if (loginUser==null) {
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        else
        {
            return true;
        }
    }
}
