package com.star.jvm.demo.design.factory.abs.pizza;

import com.star.jvm.demo.design.factory.abs.PizzaAbs;
import com.star.jvm.demo.design.factory.abs.PizzaIngredientFactory;

/**
 * 素食披萨
 */
public class VeggiePizza extends PizzaAbs {

    /**
     * 原料工厂接口
     */
    private PizzaIngredientFactory pizzaIngredientFactory;

    /**
     * 构造注入对应实现类
     * @param pizzaIngredientFactory
     */
    public VeggiePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    /**
     * 准备披萨原料(原料由对应实现类的原料工厂提供，不同原料工厂实现不同风味)
     */
    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        veggies = pizzaIngredientFactory.createVeggies();
        cheese = pizzaIngredientFactory.createCheese();
    }
}
