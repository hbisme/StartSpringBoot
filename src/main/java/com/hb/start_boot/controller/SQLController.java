package com.hb.start_boot.controller;

import com.hb.start_boot.entity.User;
import com.hb.start_boot.service.UserService;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SQLController {

    @Resource
    private UserService userService;

    @GetMapping("/getUserByName/{name}")
    public User getUserByname(@PathVariable String name){
        System.out.println("name is : " + name);
        System.out.println("userservice : " + userService);
        System.out.println("userService : " + userService.getUserByName(name));
        return userService.getUserByName(name);
    }



    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @GetMapping("/getUserByIdAndName/{id}/{name}")
    public User getUserByIdAndName(@PathVariable Long id, @PathVariable String name) {
        return userService.getUserByIdAndName(id ,name);
    }


    @Transactional
    @GetMapping("/insertUser")
    public Integer insertUser(@RequestParam Long id, @RequestParam String userName, @RequestParam String password){
        User user = new User(id, userName, password);
        return userService.insertUser(user);
    }


    @Transactional
    @GetMapping("/insertUser2")
    public Integer insertUser2(@RequestParam Long id, @RequestParam String userName, @RequestParam String password){
        User user = new User(id, userName, password);
        Integer res = userService.insertUser(user);
        throw new RuntimeException("customer exception");
    }


}
