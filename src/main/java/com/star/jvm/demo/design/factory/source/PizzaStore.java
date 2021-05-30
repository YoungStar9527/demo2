package com.star.jvm.demo.design.factory.source;

import com.star.jvm.demo.design.factory.source.domain.CheesePizza;
import com.star.jvm.demo.design.factory.source.domain.ClamPizza;
import com.star.jvm.demo.design.factory.source.domain.PepperoniPizza;
import com.star.jvm.demo.design.factory.source.domain.VeggiePizza;

/**
 * 原始披萨店类
 */
public class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza =null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

}
