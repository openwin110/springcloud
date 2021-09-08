package com.itheima.consumer.rule.impl;

import com.itheima.consumer.rule.MyLoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadBalancedImpl implements MyLoadBalanced {
    //获取下一个服务id
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private   final int getAndIncrement(){
        int current, next;
        do{
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while(!atomicInteger.compareAndSet(current, next));

        System.out.println("****next:" + next);
        return next;
    }
    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances) {
        int idx = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(idx);
    }
}
