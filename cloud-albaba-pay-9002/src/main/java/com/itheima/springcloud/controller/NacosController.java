package com.itheima.springcloud.controller;

import com.itheima.springcloud.entities.CommonResult;
import com.itheima.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
//@RequestMapping("/nacos")
public class NacosController {
    private static Map<Long, Payment> map = new HashMap<>();
    static{
        map.put(1l, new Payment(1l, "serial1001"));
        map.put(2l, new Payment(2l, "serial1002"));
        map.put(3l, new Payment(3l, "serial1003"));
    }
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        Payment payment = map.get(id);
        return new CommonResult<>(200, "from mysql, serverPort:"+serverPort, payment);
    }
}
