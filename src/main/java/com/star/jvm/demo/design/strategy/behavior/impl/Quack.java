package com.star.jvm.demo.design.strategy.behavior.impl;

import com.star.jvm.demo.design.strategy.behavior.QuackBehavior;

/**
 * 鸭叫声实现类
 */
public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("quack quack quack");
    }
}
