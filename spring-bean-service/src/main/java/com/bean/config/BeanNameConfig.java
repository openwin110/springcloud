package com.bean.config;

import com.bean.entity.BeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanNameConfig {
    @Bean("beanService")
    public BeanService getBeanService(){
        BeanService beanService = new BeanService();
//        beanService.setBeanName("1000l");
        return beanService;
    }

}
