package com.star.jvm.demo.design.strategy;

import com.star.jvm.demo.design.strategy.behavior.FlyBehavior;
import com.star.jvm.demo.design.strategy.behavior.QuackBehavior;

/**
 * 策略模式
 * 鸭子超类
 */
public abstract class Duck {

    public FlyBehavior flyBehavior;

    public QuackBehavior quackBehavior;

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("I can swim");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
