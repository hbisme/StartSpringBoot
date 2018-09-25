package com.hb.start_boot.controller;

import com.hb.start_boot.annotation.UnInterception;
import com.hb.start_boot.entity.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/listener")
public class TestListenerController {

    @GetMapping("/user")
    public User getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        return (User)application.getAttribute("user");
    }

    @GetMapping("/total")
    public String getTotalUser(HttpServletRequest request) {
        Integer count = (Integer)request.getSession().getServletContext().getAttribute("count");
        return "当前人数:" + count;
    }

    @GetMapping("/total2")
    public String getTotalUser(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie;
        try{

            cookie = new Cookie("JSESSIONID",  URLEncoder.encode(request.getSession().getId(), "utf-8"));
            cookie.setPath("/");
            cookie.setMaxAge(48*60 *60);
            response.addCookie(cookie);
        }catch ( Exception e){
            e.printStackTrace();
        }

        Integer count = (Integer)request.getSession().getServletContext().getAttribute("count");
        return "当前人数2: " + count;
    }

    @UnInterception
    @GetMapping("/request")
    public String getRequest(HttpServletRequest request) {
        System.out.println("requestListener中的初始化name数据: "  + request.getAttribute("name"));
        return "success";
    }

    @GetMapping("/publish")
    public String getRequestInfo(HttpServletRequest request){
        System.out.println("publish requestListener中的初始化的name数据: " + request.getAttribute("name"));
        return "success";
    }




}
