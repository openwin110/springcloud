package com.bean.aop.service;

import org.springframework.stereotype.Service;

@Service
public class AopDemoService {
    public void myTest(){
        System.out.println("我是Aop的myTest方法----");
    }

    public void myDemo(){
        System.out.println("我是Aop的myDemo方法----");
    }
}
