package com.itheima.hutool.service;

import com.itheima.hutool.config.IdGeneratorSnowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    private IdGeneratorSnowflake idGenerator;

    public String getIdBySnowflake(){
        return "Hello, snowflake!";
    }
}
