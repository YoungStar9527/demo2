package com.star.jvm.demo.design.templatemethod;

/**
 * 模板模式-测试类
 */
public class BeverageTestDrive {

	public static void main(String[] args) {
		Tea tea = new Tea();
		Coffee coffee = new Coffee();
 
		System.out.println("\nMaking tea...");
		//直接使用超类的方法骨架
		tea.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();

 
		TeaWithHook teaHook = new TeaWithHook();
		CoffeeWithHook coffeeHook = new CoffeeWithHook();
 
		System.out.println("\nMaking tea...");
		//直接使用超类的方法骨架，输入方式判断是否执行条件方法
		teaHook.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffeeHook.prepareRecipe();
	}



}
