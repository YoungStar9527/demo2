package com.star.jvm.demo.design.strategy.behavior.impl;

import com.star.jvm.demo.design.strategy.behavior.FlyBehavior;

/**
 * 不会飞实现类
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        //Not do something
    }
}
