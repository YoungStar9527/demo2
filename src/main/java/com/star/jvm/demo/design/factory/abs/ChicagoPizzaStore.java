package com.star.jvm.demo.design.factory.abs;

import com.star.jvm.demo.design.factory.abs.pizza.CheesePizza;
import com.star.jvm.demo.design.factory.abs.pizza.ClamPizza;
import com.star.jvm.demo.design.factory.abs.pizza.PepperoniPizza;
import com.star.jvm.demo.design.factory.abs.pizza.VeggiePizza;

/**
 * 芝加哥披萨店，根据芝加哥风味的原料制作披萨
 */
public class ChicagoPizzaStore extends AbsPizzaStore {

    @Override
    public PizzaAbs createPizza(String item) {
        PizzaAbs pizza = null;
        PizzaIngredientFactory ingredientFactory =
                new ChicagoPizzaIngredientFactory();
        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        } else if (item.equals("veggie")) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("Chicago Style Veggie Pizza");
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("Chicago Style Pepperoni Pizza");
        }
        return pizza;
    }
}
