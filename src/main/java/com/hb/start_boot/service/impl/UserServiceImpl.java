package com.hb.start_boot.service.impl;

import com.hb.start_boot.dao.UserMapper;
import com.hb.start_boot.entity.User;
import com.hb.start_boot.service.UserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        System.out.println("userMapper: " + userMapper.getUserByName(name));
        return userMapper.getUserByName(name);
    }

    @Override
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }

    @Override
    public User getUserByIdAndName(Long id, String name) {
        return userMapper.getUserByIdAndName(id, name);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    /*
    *  测试spring boot监听器
    *  获取用户详细
    * */
    public User getUser() {
        return new User(1L, "hb", "2223");
    }

}
