package com.hb.start_boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start")
public class StartSpringBoot {

    @RequestMapping("/springBoot")
    public String startSpringBoot(){
        return "welecome to spring boot!";
    }
}
