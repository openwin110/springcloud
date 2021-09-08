package com.itheima.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConumserController {
    private static final  String PAYMENT_URL = "http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/zk")
    public String getPaymentById(){
//        String uri="http://localhost:8002/payment/"+id;
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk",String.class);
//        return  restTemplate.getForObject(uri, String.class);
    }

}
