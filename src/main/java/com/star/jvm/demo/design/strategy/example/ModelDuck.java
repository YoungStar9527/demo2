package com.star.jvm.demo.design.strategy.example;

import com.star.jvm.demo.design.strategy.Duck;
import com.star.jvm.demo.design.strategy.behavior.impl.FlyNoWay;
import com.star.jvm.demo.design.strategy.behavior.impl.MuteQuack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new MuteQuack();
    }

    public void display(){
        System.out.println("I'm model");
    }
}
