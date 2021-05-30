package com.star.jvm.demo.spring.custom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyCustomTest {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        Userasdfa userasdfa = (Userasdfa)bf.getBean("testbean");
        System.out.println(userasdfa.getUserName()+","+ userasdfa.getEmail());
    }
}
