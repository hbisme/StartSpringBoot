package com.hb.start_boot.listener;

import com.hb.start_boot.entity.User;
import com.hb.start_boot.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import javax.servlet.ServletContext;

/* 数据缓存监听器类的样例
*  使用ApplicationListener来初始化一些数据到application域中的监听器
* */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        // 先获取application上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();

        // 获取对应的service
        UserService userService = applicationContext.getBean(UserService.class);
        User user = userService.getUser();

        // 获取application域对象,将查到的信息放到application域中
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("user", user);



    }
}
