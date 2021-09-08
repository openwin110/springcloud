package com.itheima.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.itheima.springcloud.dao"})
public class MybatisConfig {
}
