package com.hoperun.shuma.common.aspectj;

import com.alibaba.fastjson.JSON;
import com.hoperun.shuma.common.base.ApiMessage;
import com.hoperun.shuma.common.exception.ApiException;
import com.hoperun.shuma.common.utils.ConstantUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ZC on 2017/11/17.
 */
@Aspect
@Configuration
@Slf4j
public class ControllerAspectJ {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    private long startTimeMillis = 0; // 开始时间
    private long endTimeMillis = 0; // 结束时间

    private String uri;

    @Pointcut("execution(* com.hoperun.shuma.api.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void controllerMethodPointcut() {
    }

    /**
     * 前置通知：在某连接点之前执行的通知，但这个通知不能阻止连接点之前的执行流程（除非它抛出一个异常）。
     *
     * @param joinPoint
     */
    @Before("controllerMethodPointcut()")
    public void before(JoinPoint joinPoint) {
        startTimeMillis = System.currentTimeMillis();
        uri = request.getRequestURI();
    }

    /**
     * 后置通知：在某连接点正常完成后执行的通知，通常在一个匹配的方法返回的时候执行。
     * 如：
     *
     * @param joinPoint
     * @AfterReturning（ pointcut=com.test.service.CacheDemoService.findById(..))",returning="retVal"）
     * public void doFindByIdCheck（Object retVal） {
     * // ...
     * }
     */
    @AfterReturning(value = "controllerMethodPointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) throws IOException {
        log.info("请求开始---Send Request URL：{}, Method：{}, User-Token：{}, Params：{}", request.getRequestURL().toString(), request.getMethod(), request.getHeader(ConstantUtils.USER_TOKEN), JSON.toJSONString(joinPoint.getArgs()));
        log.info("请求方法---ClassName：{}, [Method]：{}, execution time：{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), (endTimeMillis - startTimeMillis));
        log.info("请求结束---Send Response Result：{}", JSON.toJSONString(result));
    }

    /**
     * 异常通知：在方法抛出异常退出时执行的通知。
     *
     * @param joinPoint
     */
    @AfterThrowing(value = "controllerMethodPointcut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        ApiMessage api;
        if (ApiException.class.isInstance(ex)) {
            ApiException apiEx = (ApiException) ex;
            api = new ApiMessage(apiEx);
        } else {
            api = new ApiMessage(ex);
        }
        log.error("请求开始---Send Request URL：{}, Method：{}, User-Token：{}, Params：{}", request.getRequestURL().toString(), request.getMethod(), request.getHeader(ConstantUtils.USER_TOKEN), JSON.toJSONString(joinPoint.getArgs()));
        log.error("请求方法---ClassName：{}, [Method]：{}, execution time：{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), (endTimeMillis - startTimeMillis));
        log.error("请求结束---Send Response Result：{}", JSON.toJSONString(api));
    }

    /**
     * 最终通知。当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。
     *
     * @param joinPoint
     */
    @After("controllerMethodPointcut()")
    public void after(JoinPoint joinPoint) {
        response.setHeader(ConstantUtils.USER_TOKEN, request.getHeader(ConstantUtils.USER_TOKEN));
        endTimeMillis = System.currentTimeMillis();
    }

}
