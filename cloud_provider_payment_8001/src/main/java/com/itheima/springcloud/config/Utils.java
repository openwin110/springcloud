package com.itheima.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import javax.annotation.Resource;

@Component
@Slf4j
public class Utils {
    @Resource
    private DataSourceTransactionManager dataSourceTransactionManager;

    //开始事务
    public TransactionStatus openTx(){
        return dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
    }

    //提交事务
    public void commitTx(TransactionStatus ts){
        dataSourceTransactionManager.commit(ts);
    }

    //回滚事务
    public void rollbackTx(TransactionStatus ts){
        dataSourceTransactionManager.rollback(ts);
    }
}
