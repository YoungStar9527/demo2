package com.star.jvm.demo.design.strategy.behavior.impl;

import com.star.jvm.demo.design.strategy.behavior.FlyBehavior;

/**
 * 飞行实现类
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i can fly");
    }
}
