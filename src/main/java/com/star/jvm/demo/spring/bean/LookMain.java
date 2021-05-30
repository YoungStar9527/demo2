package com.star.jvm.demo.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LookMain {
    public static void main(String[] args) {
        ApplicationContext bf =
                new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        GetBeanTest test = (GetBeanTest) bf.getBean("getBeanTest");
        test.showMe();
    }
}
