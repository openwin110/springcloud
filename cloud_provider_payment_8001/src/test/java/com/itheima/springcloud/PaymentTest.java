package com.itheima.springcloud;

import com.itheima.springcloud.pojo.Payment;
import com.itheima.springcloud.service.impl.PaymentServiceA;
import com.itheima.springcloud.service.impl.PaymentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentTest {
    @Autowired
    private PaymentServiceA paymentServiceA;

    @Autowired
    private PaymentServiceImpl paymentServiceImpl;
    @Test
    public void fun1(){
        Payment payment = paymentServiceImpl.getPaymentById(1l);
        System.out.println(payment);
    }
    //测试插入数据
    @Test
    public void fun2(){
        Payment payment1 = new Payment(4l, "jd20202023");
        Payment payment2 = new Payment(5l, "jd20202022");

        int result = paymentServiceA.create(payment1, payment2);

        if(result>0){
            System.out.println("恭喜你，订单添加成功!");
        }else{
            System.out.println("很遗憾，订单添加失败，请重新尝试！");
        }
    }

}
