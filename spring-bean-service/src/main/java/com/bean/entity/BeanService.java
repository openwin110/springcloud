package com.bean.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class BeanService implements BeanNameAware, BeanFactoryAware {
    private String beanName;
    private BeanFactory beanFactory;

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public String toString() {
        return "BeanService{" +
                "beanName='" + beanName + '\'' +
                ", beanFactory=" + beanFactory +
                '}';
    }
}
