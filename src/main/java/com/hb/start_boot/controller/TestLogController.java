package com.hb.start_boot.controller;


/* 测试logback打印日志
*
* */

import com.hb.start_boot.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class TestLogController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestLogController.class);

    @RequestMapping("/user")
    public User getUser(){
        User user = new User(1L, "hb", "888");
        LOGGER.info("执行展示用户函数");
        LOGGER.error("测试错误日志输出, user: {}", user);

        return user;
    }



}
