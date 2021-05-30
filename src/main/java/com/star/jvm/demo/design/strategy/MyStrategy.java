package com.star.jvm.demo.design.strategy;

import com.star.jvm.demo.design.strategy.behavior.impl.FlyRocketPowered;
import com.star.jvm.demo.design.strategy.example.ModelDuck;

public class MyStrategy {

    public static void main(String[] args) {
//        Duck duck = new MallardDuck();
//        duck.performQuack();
//        duck.performFly();
        Duck duckModel = new ModelDuck();
        duckModel.performQuack();
        duckModel.performFly();
        duckModel.setFlyBehavior(new FlyRocketPowered());
        duckModel.performFly();
    }
}
