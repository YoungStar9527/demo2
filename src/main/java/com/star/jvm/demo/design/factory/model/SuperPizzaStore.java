package com.star.jvm.demo.design.factory.model;

import com.star.jvm.demo.design.factory.source.Pizza;

/**
 * 工厂模式-披萨店超类
 */
public abstract class SuperPizzaStore {

    /**
     * 由子类工厂自行实现创建披萨的方法，以便创建各种不同风味的披萨
     * @param type
     * @return
     */
    protected abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

}
