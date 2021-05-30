package com.star.jvm.demo.design.factory.abs;

import com.star.jvm.demo.design.factory.abs.product.*;
import com.star.jvm.demo.design.factory.abs.product.impl.*;

/**
 * 芝加哥原料工厂实现原料超类工厂接口，对应接口返回具体的原料实现类
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{

    public Dough createDough() {
        return new ThickCrustDough();
    }

    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    public Veggies[] createVeggies() {
        Veggies veggies[] = { new BlackOlives(),
                new Spinach(),
                new Eggplant() };
        return veggies;
    }

    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    public Clams createClam() {
        return new FrozenClams();
    }
}
