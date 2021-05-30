package com.star.jvm.demo.design.factory.simple;

import com.star.jvm.demo.design.factory.source.Pizza;

/**
 * 简单工厂-披萨店类
 */
public class SimplePizzaStore {

    private SimpleFactory simpleFactory;

    public SimplePizzaStore(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = simpleFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

}
