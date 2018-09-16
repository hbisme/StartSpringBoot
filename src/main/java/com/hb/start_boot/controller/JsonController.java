package com.hb.start_boot.controller;

import com.hb.start_boot.dao.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("/user")
    public User getUser(){
        User user =  new User(1L,"hb","123456");
        return user;
    }

    @RequestMapping("/list")
    public List<User> getUserList(){
        User user1 =  new User(1L,"hb","12345");
        User user2 =  new User(2L,"fsl","7758253");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        return list;
    }

    @RequestMapping("/map")
    public Map<String, Object> getMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        User user =  new User(null,"hb","123456");
        map.put("user", user);
        map.put("address", "");
        map.put("age", 21);
        map.put("food", null);
        return map;

    }

}
