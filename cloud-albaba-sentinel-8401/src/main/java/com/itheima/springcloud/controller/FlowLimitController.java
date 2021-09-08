package com.itheima.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itheima.springcloud.entities.CommonResult;
import com.itheima.springcloud.entities.Payment;
import com.itheima.springcloud.myhandler.CustomerHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/sentinel")
public class FlowLimitController {

    @GetMapping("/test1")
    public String test1(){
        return "-----test1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "-----test2";
    }

    //熔断测试
    @GetMapping("/test3")
    public String test3(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "-----test3";
    }

    @GetMapping("/test4")
    public String test4(){
        log.info("test4---异常比例测试");
        int age = 10 / 0;
        return "-----test4";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                        @RequestParam(value = "p2", required = false) String p2){
        return "----testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "----deal_testHotKey, ^O^";
    }
    //测试服务降级
    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerHandler.class, blockHandler = "handlerException1")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200, "按资源名称限定测试ok", new Payment(2020l, "serial2020"));
    }

    public CommonResult deal_resource(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName(), "服务不可用");
    }
}
