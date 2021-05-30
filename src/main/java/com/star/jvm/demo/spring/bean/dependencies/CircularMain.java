package com.star.jvm.demo.spring.bean.dependencies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularMain {
    public static void main(String[] args) {
        ApplicationContext bf =
                new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        CircularA test = (CircularA) bf.getBean("aa");
        test.getCircularB();
    }
}
