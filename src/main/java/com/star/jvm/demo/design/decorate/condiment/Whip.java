package com.star.jvm.demo.design.decorate.condiment;

import com.star.jvm.demo.design.decorate.Beverage;
import com.star.jvm.demo.design.decorate.CondimentDecorator;

/**
 * 奶油一种调料装饰者，所以继承CondimentDecorator
 */
public class Whip extends CondimentDecorator {

    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost()+0.6;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",Whip";
    }
}
