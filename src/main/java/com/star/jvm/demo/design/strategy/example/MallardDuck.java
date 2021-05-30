package com.star.jvm.demo.design.strategy.example;

import com.star.jvm.demo.design.strategy.Duck;
import com.star.jvm.demo.design.strategy.behavior.impl.FlyWithWings;
import com.star.jvm.demo.design.strategy.behavior.impl.Quack;

/**
 * 绿头鸭
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    public void display(){
        System.out.println("I'm mallard");
    }
}
