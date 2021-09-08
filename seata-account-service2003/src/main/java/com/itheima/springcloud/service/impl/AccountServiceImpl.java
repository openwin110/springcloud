package com.itheima.springcloud.service.impl;

import com.itheima.springcloud.dao.AccountDao;
import com.itheima.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    public void decrease(Long userId, BigDecimal money){
        log.info("账户金额修改开始-------");
        /*try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        accountDao.decrease(userId, money);
        log.info("账户金额修改完成-------");
    }
}
