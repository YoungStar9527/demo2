package com.star.jvm.demo.design.decorate.condiment;

import com.star.jvm.demo.design.decorate.Beverage;
import com.star.jvm.demo.design.decorate.CondimentDecorator;

/**
 * 摩卡是一种调料装饰者，所以继承CondimentDecorator
 */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost()+0.2;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",Mocha";
    }
}
