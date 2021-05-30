package com.star.jvm.demo.spring.custom;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user123",new UserBeanDefinitionParser());
    }
}
