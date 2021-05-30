package com.star.jvm.demo.design.factory.abs;

import com.star.jvm.demo.design.factory.abs.pizza.CheesePizza;
import com.star.jvm.demo.design.factory.abs.pizza.ClamPizza;
import com.star.jvm.demo.design.factory.abs.pizza.PepperoniPizza;
import com.star.jvm.demo.design.factory.abs.pizza.VeggiePizza;

/**
 * 纽约披萨店，根据纽约风味的原料制作披萨
 */
public class NYPizzaStore extends AbsPizzaStore {

    @Override
    public PizzaAbs createPizza(String item) {
        PizzaAbs pizza = null;
        PizzaIngredientFactory ingredientFactory =
                new NyPizzaIngredientFactory();
        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (item.equals("veggie")) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }
        return pizza;
    }
}
