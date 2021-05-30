package com.star.jvm.demo.design.templatemethod;

/**
 * 咖啡-继承饮料超类
 */
public class Coffee extends CaffeineBeverage {
	/**
	 * 实现对应抽象方法
	 */
	public void brew() {
		System.out.println("Dripping Coffee through filter");
	}
	public void addCondiments() {
		System.out.println("Adding Sugar and Milk");
	}
}
