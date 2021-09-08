package com.itheima.springcloud.service;

import com.itheima.springcloud.mapper.PaymentMapper;
import com.itheima.springcloud.pojo.Payment;
import com.itheima.springcloud.service.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired(required = false)
    private PaymentMapper paymentMapper;
    //创建支付订单
    public int create(Payment payment){
        return paymentMapper.insert(payment);
    }
    //查询支付订单
    public Payment getPaymentById(Long id){
        return paymentMapper.selectByPrimaryKey(id);
    }
}
