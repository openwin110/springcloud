package com.itheima.consumer.rule;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadBalanced {
    //采用轮询方法调用一个合适的服务
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances);
}
