package com.itheima.springcloud.controller;

import com.itheima.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/stream")
public class SendMessageController {
    @Resource
    private IMessageProvider iMessageProvider;

    @RequestMapping("/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
