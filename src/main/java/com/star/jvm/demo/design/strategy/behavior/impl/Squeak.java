package com.star.jvm.demo.design.strategy.behavior.impl;

import com.star.jvm.demo.design.strategy.behavior.QuackBehavior;

/**
 * 吱吱叫/橡皮鸭子
 */
public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak Squeak Squeak");
    }
}
