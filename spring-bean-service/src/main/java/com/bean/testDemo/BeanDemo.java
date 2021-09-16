package com.bean.testDemo;

import com.bean.config.BeanNameConfig;
import com.bean.config.MyConfig;
import com.bean.entity.BeanService;
import com.bean.entity.PrototypeBean;
import com.bean.entity.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDemo {
    @Autowired
    private static BeanService beanService;
    public static void main(String[] args) {
        /*ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);
        SingletonBean s1 = ac.getBean("singletonBean", SingletonBean.class);
        SingletonBean s2 = ac.getBean("singletonBean", SingletonBean.class);
        PrototypeBean p1 = ac.getBean("prototypeBean", PrototypeBean.class);
        PrototypeBean p2 = ac.getBean("prototypeBean", PrototypeBean.class);
        System.out.println(s1 + "\t" + s2 + "\t" + p1 + "\t" + p2);*/
        ApplicationContext ac = new AnnotationConfigApplicationContext(BeanNameConfig.class);
        BeanService bs = ac.getBean("beanService", BeanService.class);
        System.out.println(bs.getBeanName());
        System.out.println(bs.getBeanFactory().getBean(bs.getBeanName()));

    }
}
