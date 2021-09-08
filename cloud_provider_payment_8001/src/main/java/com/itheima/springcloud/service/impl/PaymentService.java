package com.itheima.springcloud.service.impl;

import com.itheima.springcloud.pojo.Payment;

public interface PaymentService {
    //创建订单
    public int create(Payment payment);

    //根据订单号获取订单
    public Payment getPaymentById(Long id);
}
