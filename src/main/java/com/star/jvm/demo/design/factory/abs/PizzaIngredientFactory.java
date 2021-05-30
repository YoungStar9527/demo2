package com.star.jvm.demo.design.factory.abs;

import com.star.jvm.demo.design.factory.abs.product.*;

/**
 * 抽象工厂-原料工厂超类(定义相关原料接口方法，对应实现原料交给子类完成)
 */
public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
