package com.star.jvm.demo.design.combining.composite;

/**
 * 抽象工厂模式-抽象类
 */
public abstract class AbstractDuckFactory {
 
	public abstract Quackable createMallardDuck();
	public abstract Quackable createRedheadDuck();
	public abstract Quackable createDuckCall();
	public abstract Quackable createRubberDuck();
}
