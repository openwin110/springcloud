package com.bean.aop.Controller;

import com.bean.aop.config.MyConfig;
import com.bean.aop.service.AopDemoService;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AopTestDemo {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);
        AopDemoService ad = ac.getBean("aopDemoService", AopDemoService.class);
        ad.myTest();
        ad.myDemo();
    }

}
