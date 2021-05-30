package com.star.jvm.demo.design.adapter.intfa.impl;

import com.star.jvm.demo.design.adapter.intfa.Duck;

public class MallardDuck implements Duck {
	public void quack() {
		System.out.println("Quack");
	}
 
	public void fly() {
		System.out.println("I'm flying");
	}
}
