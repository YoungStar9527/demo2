package com.star.jvm.demo.design.composite.menuiterator;

import java.util.Iterator;

/**
 * 树的节点抽象类(组合/叶子)(菜单/菜品)
 */
public abstract class MenuComponent {

	/**
	 * 添加节点
	 * @param menuComponent
	 */
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 删除节点
	 * @param menuComponent
	 */
	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 获取对应节点
	 * @param i
	 * @return
	 */
	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}


	public String getName() {
		throw new UnsupportedOperationException();
	}
	public String getDescription() {
		throw new UnsupportedOperationException();
	}
	public double getPrice() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 是否素食
	 * @return
	 */
	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 菜单迭代器
	 * @return
	 */
	public abstract Iterator<MenuComponent> createIterator();

	/**
	 * 叶子/菜单基本信息
	 */
	public void print() {
		throw new UnsupportedOperationException();
	}
}
