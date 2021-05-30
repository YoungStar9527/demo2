package com.star.jvm.demo.design.templatemethod;

import java.io.*;

/**
 * 咖啡-继承饮料超类
 */
public class CoffeeWithHook extends CaffeineBeverageWithHook {

	/**
	 * 实现对应抽象方法
	 */
	public void brew() {
		System.out.println("Dripping Coffee through filter");
	}
 
	public void addCondiments() {
		System.out.println("Adding Sugar and Milk");
	}

	/**
	 * 覆盖条件方法，通过getUserInput判断是否执行条件
	 * @return
	 */
	public boolean customerWantsCondiments() {

		String answer = getUserInput();

		if (answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 命令行输入返回对应状态
	 * @return
	 */
	private String getUserInput() {
		String answer = null;

		System.out.print("Would you like milk and sugar with your coffee (y/n)? ");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = in.readLine();
		} catch (IOException ioe) {
			System.err.println("IO error trying to read your answer");
		}
		if (answer == null) {
			return "no";
		}
		return answer;
	}
}
