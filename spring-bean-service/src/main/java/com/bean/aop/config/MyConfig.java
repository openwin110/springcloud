package com.bean.aop.config;

import com.bean.aop.service.AopDemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class MyConfig {
    @Bean("aopDemoService")
    public AopDemoService getAspectService(){
        return new AopDemoService();
    }
}
