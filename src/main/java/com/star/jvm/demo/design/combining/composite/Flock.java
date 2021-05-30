package com.star.jvm.demo.design.combining.composite;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * 鸭群类
 */
public class Flock implements Quackable {
	ArrayList<Quackable> quackers = new ArrayList<Quackable>();
 
	public void add(Quackable quacker) {
		quackers.add(quacker);
	}

	/**
	 * 利用迭代器，遍历鸭群
	 */
	public void quack() {
		Iterator<Quackable> iterator = quackers.iterator();
		while (iterator.hasNext()) {
			Quackable quacker = iterator.next();
			quacker.quack();
		}
	}
 
	public String toString() {
		return "Flock of Quackers";
	}
}
