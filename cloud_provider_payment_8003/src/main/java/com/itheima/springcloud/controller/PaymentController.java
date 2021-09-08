package com.itheima.springcloud.controller;

import com.itheima.springcloud.pojo.CommonResult;
import com.itheima.springcloud.pojo.Payment;
import com.itheima.springcloud.service.impl.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    //创建支付订单
    @PostMapping("/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果："+result);
        if(result>0){
            return new CommonResult(200,"创建订单成功!"+",serverPort="+serverPort,result);
        }else{
            return new CommonResult(444,"创建订单失败"+",serverPort="+serverPort,null);
        }
    }
    //根据Id查询支付订单
    @GetMapping("/{id}")
    public CommonResult<Object> getPaymentById(@PathVariable Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("查询结果:"+payment);
        if(payment!=null){
            return new CommonResult(200,"查询订单成功!"+",serverPort="+serverPort,payment);
        }else{
            return new CommonResult(444,"查询失败，没有结果!"+",serverPort="+serverPort,null);
        }
    }
    //测试
    @GetMapping("/consumer/{id}")
    public Payment getPaymentById1(@PathVariable Long id){
        System.out.println(id);
        Payment payment=paymentService.getPaymentById(id);
        log.info("查询结果:"+payment);
        return payment;
    }

    //测试自写轮询负载均衡算法
    @GetMapping("/ribbon")
    public String getServerPort(){
        return serverPort;
    }

}
