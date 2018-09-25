package com.hb.start_boot.controller;

import com.hb.start_boot.entity.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mvc")
public class MVCTest {
    @GetMapping("/users")
    public String getUser() {
        return "success";
    }

    @GetMapping("/user/{id}/{type}")  // 对应url地址里的id变量
    public String getUser(@PathVariable Integer id, @PathVariable String type) {
        return "user: " + id + " type: " + type + " success";
    }

    @GetMapping("/user")
    public String getUserRequestParam
            (@RequestParam Integer id,
             @RequestParam(required = false, defaultValue = "noType") String type) {  // RequestParam 注解对应于get的参数变量
        return "id: " + id + " type: " + type;
    }

    @PostMapping("/user")
    public String postUserRequestParam
            (@RequestParam Integer id,
             @RequestParam(required = false, defaultValue = "noType") String type) {  //RequestParam 注解也可以对应post的参数变量,required 设置是否必须
        return "id: " + id + " type: " + type;
    }


    @PostMapping("/form")
    // 用实体类来表示接收的参数,这样不用写很多@RequestParam注解,但是类字段默认都required = false,用于post表单(key,value)形式提交
    public String fromForm(User user){
        System.out.println("id is: " + user.getId());
        System.out.println("name is: "+ user.getUserName());
        System.out.println("password is: " + user.getPassword());
        return "success";
    }

    /*
    * 使用RequestBody 修饰的User类,必须有无参构造方法
    * 在post提交时候,用的是raw形式,类型是application/json,内容是json字符串
    * */
    @PostMapping("/form2")
    public String fromRequestBody(@RequestBody User user){
        System.out.println("request id is: " + user.getId());
        System.out.println("request name is: "+ user.getUserName());
        System.out.println("request password is: " + user.getPassword());
        return "success";
    }
}
