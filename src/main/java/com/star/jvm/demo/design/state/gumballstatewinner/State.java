package com.star.jvm.demo.design.state.gumballstatewinner;

/**
 * 状态类接口
 * 状态的所有动作
 */
public interface State {

	/**
	 * 投入钱
	 */
	public void insertQuarter();

	/**
	 * 退回钱
	 */
	public void ejectQuarter();

	/**
	 * 转动曲柄
	 */
	public void turnCrank();

	/**
	 * 出售糖果
	 */
	public void dispense();

	/**
	 * 注满糖果
	 */
	public void refill();
}
