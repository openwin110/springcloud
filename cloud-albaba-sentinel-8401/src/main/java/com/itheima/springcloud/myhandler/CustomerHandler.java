package com.itheima.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itheima.springcloud.entities.CommonResult;
import jdk.nashorn.internal.ir.Block;

public class CustomerHandler {
    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(444, "服务不可用---1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444, "服务不可用---2");
    }
}
