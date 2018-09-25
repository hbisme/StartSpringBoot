package com.hb.start_boot.controller;

import com.hb.start_boot.entity.JpaUser;
import com.hb.start_boot.jpa.UserJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mysql")
public class MysqlJpaController {

    @Autowired
    private UserJPA userJPA;


    @PostMapping("/list")
    public List<JpaUser> list(){
        return userJPA.findAll();
    }
}
