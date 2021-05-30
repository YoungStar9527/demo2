package com.star.jvm.demo.design.strategy.behavior.impl;

import com.star.jvm.demo.design.strategy.behavior.QuackBehavior;

/**
 * 不会叫 沉默的
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        // not do something
    }
}
