package com.star.jvm.demo.design.templatemethod;

/**
 * 模板模式超类-饮料类
 */
public abstract class CaffeineBeverageWithHook {

	/**
	 * 定义一个final类不可改变的方法骨架，调用对应方法
	 */
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		/**
		 * 默认为true执行，子类也可以覆盖条件方法，改变状态，使方法不被执行
		 */
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}

	/**
	 * 对应抽象的方法子类必须实现
	 */
	abstract void brew();
 
	abstract void addCondiments();

	/**
	 * 确定的方法子类直接继承
	 */
	void boilWater() {
		System.out.println("Boiling water");
	}
 
	void pourInCup() {
		System.out.println("Pouring into cup");
	}

	/**
	 * 一个条件方法(勾子),可以通过此方法设置对应方法是否执行
	 * @return
	 */
	boolean customerWantsCondiments() {
		return true;
	}
}
