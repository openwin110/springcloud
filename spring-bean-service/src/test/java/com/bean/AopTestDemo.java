package com.bean;

import com.bean.aop.config.AspectService;
import com.bean.aop.service.AopDemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AopTestDemo {
    @Autowired
    private AopDemoService aopDemoService;

    @Test
    public void fun(){
        aopDemoService.myDemo();
        aopDemoService.myTest();
    }
}
