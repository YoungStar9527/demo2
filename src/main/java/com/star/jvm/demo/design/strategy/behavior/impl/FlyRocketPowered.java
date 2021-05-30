package com.star.jvm.demo.design.strategy.behavior.impl;

import com.star.jvm.demo.design.strategy.behavior.FlyBehavior;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I’m flying with a rocket!");
    }
}
