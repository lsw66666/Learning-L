package com.example.shixun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginHandlerInterceptor  implements HandlerInterceptor   {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {



        //登陆成功之后，应该有用户的session
        Object loginUser=  request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            System.out.println("=================");
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return  false;
        }
        else {
            return true;
        }
    }


}
