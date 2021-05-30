package com.star.jvm.demo.design.decorate;

/**
 * 饮料超类
 */
public abstract class Beverage {

    public String description = "UnKnow beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
