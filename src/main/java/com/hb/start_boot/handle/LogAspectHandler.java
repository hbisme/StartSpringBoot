package com.hb.start_boot.handle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

@Aspect   // 表示类是一个切面类
@Component   // 表示交给spring来管理
public class LogAspectHandler {
    public static final Logger logger = LoggerFactory.getLogger(LogAspectHandler.class);

    //Pointcut注解指定一个切面,定义需要拦截的东西
    @Pointcut("execution(* com.hb.start_boot.controller..*.*(..))")
    public void pointCut(){}

//     对某个类下的所有指定注解的切面
//    @Pointcut("@annotation(com.hb.start_boot.controller.MVCTest.GetMapping)")
//    public void annotationCut(){}

    @Before("pointCut()")  //Before注解中的value 和
    // JointPoint对象很有用,可以用他获取一个签名,用这个签名获取请求的包名,方法名,参数等
    public void doBefore(JoinPoint joinPoint){
        logger.info("===do before 方法进入了==");
        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        // 获取即将执行的方法名
        String funcName = signature.getName();
        logger.info("即将执行方法为: {}, 属于{}包", funcName, declaringTypeName);

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        logger.info("用户请求的url为: {}, ip地址为: {}", url, ip);

    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        logger.info("===doAfter方法进入了===");
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        logger.info("方法: {} 执行完了,", method);
    }

    /*
    * 对方法执行完的返回值进行增强,如果发送异常,不会执行这个方法
    * */
    @AfterReturning(pointcut = "pointCut()", returning = "result")  // returning 参数的值,必须和方法中的参数名称相同
    public void doAfterReturning(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        logger.info("方法: {}执行完了, 返回值是: {}", method, result);
    }

    /*
    * 对异常进行增强,发生异常,doAfter 切面方法
    * */
    @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable ex){
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        logger.info("方法: {}执行异常,异常是: {}", method, ex.toString());
    }

}
