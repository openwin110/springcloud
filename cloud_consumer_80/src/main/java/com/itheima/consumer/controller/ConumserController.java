package com.itheima.consumer.controller;

import com.itheima.consumer.rule.MyLoadBalanced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConumserController {
    private static final  String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private MyLoadBalanced myLoadBalanced;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/{id}")
    public String getPaymentById(@PathVariable Long id){
//        String uri="http://localhost:8002/payment/"+id;
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id,String.class);
//        return  restTemplate.getForObject(uri, String.class);
    }

    //测试自写负载均衡算法
    @GetMapping("/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0)
            return null;
        ServiceInstance serviceInstance = myLoadBalanced.getServiceInstance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/ribbon", String.class);
    }

}
