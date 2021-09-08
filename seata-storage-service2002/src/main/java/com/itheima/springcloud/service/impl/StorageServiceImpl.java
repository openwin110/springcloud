package com.itheima.springcloud.service.impl;

import com.itheima.springcloud.dao.StorageDao;
import com.itheima.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("库存修改开始------");
        storageDao.decrease(productId, count);
        log.info("库存修改完成");
    }
}
