package com.star.jvm.demo.design.decorate.beverage;

import com.star.jvm.demo.design.decorate.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
