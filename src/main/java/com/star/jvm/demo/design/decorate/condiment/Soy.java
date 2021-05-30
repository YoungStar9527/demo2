package com.star.jvm.demo.design.decorate.condiment;

import com.star.jvm.demo.design.decorate.Beverage;
import com.star.jvm.demo.design.decorate.CondimentDecorator;

/**
 * 酱油是一种调料装饰者，所以继承CondimentDecorator
 */
public class Soy extends CondimentDecorator {

    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost()+0.3;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",Soy";
    }
}
