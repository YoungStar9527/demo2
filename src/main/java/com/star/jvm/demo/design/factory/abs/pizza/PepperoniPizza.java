package com.star.jvm.demo.design.factory.abs.pizza;

import com.star.jvm.demo.design.factory.abs.PizzaAbs;
import com.star.jvm.demo.design.factory.abs.PizzaIngredientFactory;

public class PepperoniPizza extends PizzaAbs {


	/**
	 * 原料工厂接口
	 */
	PizzaIngredientFactory ingredientFactory;

	/**
	 * 构造注入对应实现类
	 * @param ingredientFactory
	 */
	public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	/**
	 * 准备披萨原料(原料由对应实现类的原料工厂提供，不同原料工厂实现不同风味)
	 */
	public void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		veggies = ingredientFactory.createVeggies();
		pepperoni = ingredientFactory.createPepperoni();
	}
}
