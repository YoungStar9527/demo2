package com.star.jvm.demo.design.factory.simple;

import com.star.jvm.demo.design.factory.source.domain.CheesePizza;
import com.star.jvm.demo.design.factory.source.domain.ClamPizza;
import com.star.jvm.demo.design.factory.source.domain.PepperoniPizza;
import com.star.jvm.demo.design.factory.source.domain.VeggiePizza;
import com.star.jvm.demo.design.factory.source.Pizza;

/**
 * 简单工厂类
 */
public class SimpleFactory {

    public Pizza createPizza(String type){
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
        return pizza;
    }
}
