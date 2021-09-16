package com.bean.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectService {
    @Before("execution(public * com.bean.aop.service.AopDemoService.*(..))")
    public void doCheck(){
        System.out.println("[before]这是执行doCheck方法----");
    }

    @Around("execution(public * com.bean.aop.service.AopDemoService.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[around-start]执行:" + pjp.getSignature());
        Object proceed = pjp.proceed();
        System.out.println("[around-end]结束:" + pjp.getSignature());
        return proceed;
    }
}
