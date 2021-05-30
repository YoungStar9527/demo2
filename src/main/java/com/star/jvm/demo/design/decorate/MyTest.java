package com.star.jvm.demo.design.decorate;

import com.star.jvm.demo.design.decorate.beverage.Espresso;
import com.star.jvm.demo.design.decorate.condiment.Mocha;
import com.star.jvm.demo.design.decorate.condiment.Soy;
import com.star.jvm.demo.design.decorate.condiment.Whip;

public class MyTest {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println("description:"+beverage.getDescription()+",$"+beverage.cost());
        Beverage beverageTwo = new Espresso();
        beverageTwo = new Mocha(beverageTwo);
        beverageTwo = new Soy(beverageTwo);
        beverageTwo = new Whip(beverageTwo);
        System.out.println("description:"+beverageTwo.getDescription()+",$"+beverageTwo.cost());
    }
}
