package com.hb.start_boot.controller;

import com.hb.start_boot.configure.MicroServiceUrl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class ConfigController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);

    @Value("${url.orderUrl}")   // 用来获取application.yml 中的自定义配置
    private String orderUrl;

    @RequestMapping("/config")
    public String testConfig(){
        LOGGER.info("获取订单地址: {}" , orderUrl);
        return "success";
    }

    @Resource  // 引用配置类
    private MicroServiceUrl microServiceUrl;

    @RequestMapping("/config2")
    public String testConfig2(){
        LOGGER.info("获取订单接口: {}", microServiceUrl.getOrderUrl());
        LOGGER.info("获取用户接口: {}", microServiceUrl.getUserUrl());
        LOGGER.info("获取shop接口: {}", microServiceUrl.getShopUrl());

        return "success";
    }

    /*
    *  另外一种获取配置的方法,使用注入的Environment
    * */
    @Autowired
    Environment env;
    @GetMapping("/environment")
    public String getShopUrl(){
        String shopUrl = env.getProperty("url.shopUrl", String.class);
        LOGGER.info("另外一种获取 shop接口: {}", shopUrl );
        return shopUrl;
    }


}
