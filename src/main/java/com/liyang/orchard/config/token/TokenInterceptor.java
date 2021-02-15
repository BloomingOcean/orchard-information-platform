package com.liyang.orchard.config.token;

import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.utils.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取token
        String token = request.getHeader(TokenUtil.tokenHeader);
        System.out.println("token===================="+token);
        if (null==token) {
//            response.sendRedirect("http://127.0.0.1:8080/login");
            System.out.println("没有携带token");
            return false;
        }
        try {
            TokenUtil.getTokenBody(token);
        } catch (Exception e) {
            e.printStackTrace();
//            response.sendRedirect("http://127.0.0.1:8080/login");
            System.out.println("token有问题");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}