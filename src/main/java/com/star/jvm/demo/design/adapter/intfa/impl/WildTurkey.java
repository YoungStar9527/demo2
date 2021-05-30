package com.star.jvm.demo.design.adapter.intfa.impl;

import com.star.jvm.demo.design.adapter.intfa.Turkey;

public class WildTurkey implements Turkey {
	public void gobble() {
		System.out.println("Gobble gobble");
	}
 
	public void fly() {
		System.out.println("I'm flying a short distance");
	}
}
