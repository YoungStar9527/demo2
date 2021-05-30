package com.star.jvm.demo.design.factory.model;

import com.star.jvm.demo.design.factory.model.ny.NYStyleCheesePizza;
import com.star.jvm.demo.design.factory.model.ny.NYStyleClamPizza;
import com.star.jvm.demo.design.factory.model.ny.NYStylePepperoniPizza;
import com.star.jvm.demo.design.factory.model.ny.NYStyleVeggiePizza;
import com.star.jvm.demo.design.factory.source.Pizza;

/**
 * 纽约风味的披萨店
 */
public class NYPizzaStore extends SuperPizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza =null;
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new NYStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new NYStyleVeggiePizza();
        }
        return pizza;
    }
}
