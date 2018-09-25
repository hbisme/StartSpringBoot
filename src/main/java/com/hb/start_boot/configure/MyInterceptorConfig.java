package com.hb.start_boot.configure;

import com.hb.start_boot.interceptor.MyInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*
*  配置拦截器
* */

@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }


    /*
    *  * 用来指定静态资源不被拦截，否则继承WebMvcConfigurationSupport这种方式会导致静态资源无法直接访问
     * */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registy){
        registy.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registy);
    }

}
