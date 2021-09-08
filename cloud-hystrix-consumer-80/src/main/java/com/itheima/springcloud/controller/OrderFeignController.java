package com.itheima.springcloud.controller;

import com.itheima.springcloud.entities.CommonResult;
import com.itheima.springcloud.entities.Payment;
import com.itheima.springcloud.feign.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/consumer")
//@DefaultProperties(defaultFallback = "globalFallBack")
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    //测试正常查询
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfo_ok(id);
    }
//    @HystrixCommand(fallbackMethod = "exceptionHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
//    })
//    @HystrixCommand
    //测试熔断超时
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfo_timeout(id);
    }

    public String exceptionHandler(Integer id){
        return "我是端口为80的订单用户，在调用支付服务时出错，请检查修正id" + id;
    }
    //定义一个全局调用方法
    public String globalFallBack(){
        return "Global异常处理信息，请稍后再试！";
    }
}
