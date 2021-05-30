package com.star.jvm.demo.design.templatemethod;

/**
 * 茶-继承饮料超类
 */
public class Tea extends CaffeineBeverage {

	/**
	 * 实现对应抽象方法
	 */
	public void brew() {
		System.out.println("Steeping the tea");
	}
	public void addCondiments() {
		System.out.println("Adding Lemon");
	}
}
