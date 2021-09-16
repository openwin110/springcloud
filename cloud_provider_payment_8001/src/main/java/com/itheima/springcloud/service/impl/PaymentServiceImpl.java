package com.itheima.springcloud.service.impl;

import com.itheima.springcloud.config.Utils;
import com.itheima.springcloud.mapper.PaymentMapper;
import com.itheima.springcloud.pojo.Payment;
import com.itheima.springcloud.service.impl.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Autowired(required = false)
    private PaymentMapper paymentMapper;
    @Autowired
    private Utils utils;
    //创建支付订单 编程式事务管理
    /*public int create(Payment payment){
        TransactionStatus ts = null;
        int is_ok = -1;
        try{
            log.info("--开启事务--");
            ts = utils.openTx();

            is_ok = paymentMapper.insert(payment);
            int idx = 1 / 0;
            if(ts != null){
                log.info("--事务提交开始--");
                utils.commitTx(ts);
                log.info("--事务提交结束--");
            }

        }catch (Exception e){
            if(ts != null){
                log.info("--事务回滚开始--");
                utils.rollbackTx(ts);
                log.info("--事务回滚结束--");

            }
        }
        return is_ok;
    }*/
    //创建订单  声明式事务管理
    @Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED)
    public int create(Payment payment){
        int is_ok = paymentMapper.insert(payment);
        int idx = 1 / 0;
        return is_ok;
    }
    //查询支付订单
    public Payment getPaymentById(Long id){
        return paymentMapper.selectByPrimaryKey(id);
    }
}
