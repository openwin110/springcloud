package com.itheima.springcloud.service.impl;

import com.itheima.springcloud.pojo.Payment;
import com.itheima.springcloud.mapper.PaymentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class PaymentServiceA {
    @Resource
    private PaymentMapper paymentMapper;

    @Resource
    private PaymentService paymentService;

    @Transactional
    public int create(Payment payment1, Payment payment2){
        int info = paymentMapper.updateByPrimaryKey(payment1);
        try{
            paymentService.create(payment2);
        }catch (Exception e){
            e.printStackTrace();
        }
//        int it = 1 / 0;
        return info;
    }
}
