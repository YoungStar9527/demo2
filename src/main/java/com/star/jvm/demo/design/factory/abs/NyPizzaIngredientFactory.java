package com.star.jvm.demo.design.factory.abs;

import com.star.jvm.demo.design.factory.abs.product.*;
import com.star.jvm.demo.design.factory.abs.product.impl.*;

/**
 * 纽约原料工厂实现原料超类工厂接口，对应接口返回具体的原料实现类
 */
public class NyPizzaIngredientFactory implements PizzaIngredientFactory{

    public Dough createDough() {
        return new ThinCrustDough();
    }

    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
        return veggies;
    }

    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    public Clams createClam() {
        return new FreshClams();
    }
}
