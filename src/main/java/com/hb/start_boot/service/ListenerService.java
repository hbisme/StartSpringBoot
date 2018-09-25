package com.hb.start_boot.service;

import com.hb.start_boot.entity.User;
import com.hb.start_boot.event.MyEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ListenerService {

    @Resource
    private ApplicationContext applicationContext;

    /*
    * 发布事件
    * */

    public User getUser2() {
        User user = new User(2L, "hubin", "988888");
        // 发布事件
        MyEvent event = new MyEvent(this, user);
        applicationContext.publishEvent(event);
        return user;

    }



}
