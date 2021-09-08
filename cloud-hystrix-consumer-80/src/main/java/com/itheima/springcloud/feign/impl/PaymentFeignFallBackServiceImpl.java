package com.itheima.springcloud.feign.impl;

import com.itheima.springcloud.feign.PaymentFeignService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignFallBackServiceImpl implements PaymentFeignService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "paymentFeign fall back-paymentInfo_ok, o^o";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "paymentFeign fall back-paymentInfo_timeout, o^o";
    }
}
