package com.star.jvm.demo.design.factory.model;

import com.star.jvm.demo.design.factory.model.chicago.ChicagoStyleCheesePizza;
import com.star.jvm.demo.design.factory.model.chicago.ChicagoStyleClamPizza;
import com.star.jvm.demo.design.factory.model.chicago.ChicagoStylePepperoniPizza;
import com.star.jvm.demo.design.factory.model.chicago.ChicagoStyleVeggiePizza;
import com.star.jvm.demo.design.factory.source.Pizza;

/**
 * 芝加哥风味的披萨店
 */
public class ChicagoPizzaStore extends SuperPizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza =null;
        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ChicagoStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }
}
