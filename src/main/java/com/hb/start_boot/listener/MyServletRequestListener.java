package com.hb.start_boot.listener;


/*
* 使用ServletRequestListener获取访问信息
* */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyServletRequestListener implements ServletRequestListener {

    private static final Logger logger = LoggerFactory.getLogger(MyServletRequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequestEvent.getServletRequest();
        logger.info("session id为: {}", httpServletRequest.getRequestedSessionId());
        logger.info("request url 为: {}",  httpServletRequest.getRequestURL());

        httpServletRequest.setAttribute("name", "tiancai");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        logger.info("request end");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequestEvent.getServletRequest();
        logger.info("request 域中保存的name值为:{}", httpServletRequest.getAttribute("name"));
    }


}
