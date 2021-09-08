package com.itheima.springcloud.service;

import com.itheima.springcloud.domain.Order;

public interface OrderService {
    //创建订单
    void create(Order order);
}
