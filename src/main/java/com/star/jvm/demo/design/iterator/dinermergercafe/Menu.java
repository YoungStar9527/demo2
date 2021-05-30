package com.star.jvm.demo.design.iterator.dinermergercafe;

import java.util.Iterator;

/**
 * 菜单接口
 */
public interface Menu {

	/**
	 * 获取菜单的迭代器
	 * @return
	 */
	public Iterator<MenuItem> createIterator();
}
