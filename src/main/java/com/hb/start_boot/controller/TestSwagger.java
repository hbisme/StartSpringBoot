package com.hb.start_boot.controller;

import com.hb.start_boot.entity.JsonResult;
import com.hb.start_boot.entity.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/swagger")
@Api(value = "swagger2 在线接口文档")  //@Api 注解修饰于类上,标示这个类是swagger的资源
public class TestSwagger {

    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据用户id来获取用户信息")  // @ApiOperation 注解修饰于方法上,表示一个http请求的操作.
    public JsonResult<User> getUserInfo(@PathVariable @ApiParam(value = "用户id") Long id){   // @Api Param注解修饰于参数上,表示参数信息.
        User user = new User(id , "hb", "123");
        return new JsonResult<User>(user);
    }

}
