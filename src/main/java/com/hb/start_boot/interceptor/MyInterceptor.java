package com.hb.start_boot.interceptor;

import com.hb.start_boot.annotation.UnInterception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
*  自定义一个拦截器
* */
public class MyInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        logger.info("===拦截到了方法: {},在方法执行前调用==", methodName);

        UnInterception unInterception = method.getAnnotation(UnInterception.class);
        if( null != unInterception){
            return  true;
        }

        String token = request.getParameter("token");
        if(null == token || "" == token){
            logger.info("用户未登录,没有权限...请登录");
//            return  false;   // 注释掉拦截器,不然会拦截所有请求
            return true;
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("执行完方法之后进行(Controller方法调用之后),但是此时还没进行视图渲染.");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("这个请求都处理完了, DispatcherServlet也渲染完对应的视图,此时我可以做一些清理工作.");
    }
}
