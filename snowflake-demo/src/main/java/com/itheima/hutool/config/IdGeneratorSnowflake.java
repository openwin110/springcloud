package com.itheima.hutool.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class IdGeneratorSnowflake {
    private Long workerId = 0l, datacenterId  = 1l;
    private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

    //进行初始化
    @PostConstruct
    public void init(){
        try{
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前workerId = {}", workerId);
        }catch (Exception e){
            e.printStackTrace();
            log.warn("当前机器wordId获取失败", e);
            workerId = (long)NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }


    public static void main(String[] args) {
//        System.out.println(new IdGeneratorSnowflake().snowflakeId());
        ExecutorService ec = Executors.newFixedThreadPool(5);
        String host = NetUtil.getLocalhostStr();
        long ipToLong = NetUtil.ipv4ToLong(host);
        System.out.println(host+ "->" + ipToLong);
        IdGeneratorSnowflake idGenerator = new IdGeneratorSnowflake();
        for(int i = 0; i < 20; ++i){
            ec.execute(()->{
                System.out.println(Thread.currentThread().getName() + ": " + idGenerator.snowflakeId());
            });
        }

        ec.shutdown();
    }
}
