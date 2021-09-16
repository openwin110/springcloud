package com.bean.config;

import com.bean.entity.PrototypeBean;
import com.bean.entity.SingletonBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {
    @Bean("singletonBean")
    @Scope("singleton")
    public SingletonBean getSingleton(){
        return new SingletonBean();
    }

    @Bean("prototypeBean")
    @Scope("prototype")
    public PrototypeBean getPrototype(){
        return new PrototypeBean();
    }
}
