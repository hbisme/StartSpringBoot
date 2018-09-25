package com.hb.start_boot.controller;

import com.hb.start_boot.common.BusinessErrorException;
import com.hb.start_boot.common.enums.BusinessMsgEnum;
import com.hb.start_boot.entity.JsonResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);


    @PostMapping("/test")
    // 默认RequestParam修饰的是必选参数
    public JsonResult test(@RequestParam String name, @RequestParam String pass) {
        logger.info("name: {}", name);
        logger.info("pass: {}", pass);
        return new JsonResult();
    }

    // 测试系统异常,i/j,当j为0时候,全局异常会封装这个系统异常,返回封装后的json
    @GetMapping("/test2")
    public JsonResult test2(@RequestParam Integer i, @RequestParam Integer j ){
        logger.info("i: {}", i);
        logger.info("j: {}", j);
        int res = i/j;
        return new JsonResult<Integer>(res);
    }


    // 测试自定义业务异常
    @GetMapping("/business")
    public JsonResult testBusinessException(){
        try{
            int i = 1/0;
        }catch (Exception e){
            throw new BusinessErrorException(BusinessMsgEnum.UNEXPECTED_EXCERTION);
        }
        return new JsonResult();
    }
}
