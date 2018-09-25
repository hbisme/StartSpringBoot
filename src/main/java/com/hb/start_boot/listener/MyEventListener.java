package com.hb.start_boot.listener;

import com.hb.start_boot.entity.User;
import com.hb.start_boot.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/*
* 自定义监听器,监听myEvent事件
* */

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        // 把事件中的信息获取到
        User user = myEvent.getUser();

        // 处理事件,实际项目中科院通知别的微服务或者处理其他逻辑
        System.out.println("用户名: " + user.getUserName());
        System.out.println("密码: " + user.getPassword());
    }
}
