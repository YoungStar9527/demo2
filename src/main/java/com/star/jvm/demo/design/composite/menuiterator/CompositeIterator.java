package com.star.jvm.demo.design.composite.menuiterator;

import java.util.*;

/**
 * 树菜单迭代器
 */
public class CompositeIterator implements Iterator<MenuComponent> {

	/**
	 * 栈后进先出(羽毛球桶)
	 */
	Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();

	/**
	 * 构造注入栈的第一个元素
	 * @param iterator
	 */
	public CompositeIterator(Iterator<MenuComponent> iterator) {
		stack.push(iterator);
	}

	/**
	 * 栈后进先出!! 后进的出栈了，先进的继续遍历!!
	 * 利用栈的特性，菜单数组对应下标遍历所有元素，再开始遍历下一个下标中的所有元素，依次类推
	 * (后进先出!!最底下的出栈了，直接回到上层，依次类推)
	 * @return
	 */
	public MenuComponent next() {
		//hasNext()会检查栈顶是否为空，为空则出栈，直到栈为空返回false
		if (hasNext()) {
			//获取栈顶迭代器
			Iterator<MenuComponent> iterator = stack.peek();
			//迭代器取出元素(取出/并未出栈)
			MenuComponent component = iterator.next();
			//元素的迭代器入栈(子节点集合/叶子入栈)(菜单元素为对应子菜品数组，菜品元素则为空迭代器)
			stack.push(component.createIterator());
			//返回该元素(返回元素供打印信息)
			return component;
		} else {
			return null;
		}
	}

	/**
	 * 递归是我的朋友 di gui is my friend
	 * @return
	 */
	public boolean hasNext() {
		//栈为空返回false
		if (stack.empty()) {
			return false;
		} else {
			//获取栈顶元素
			Iterator<MenuComponent> iterator = stack.peek();
			//判断栈顶迭代器是否有值
			if (!iterator.hasNext()) {
				//无值则出栈，进行递归(遍历下一个(其实是上一个入栈的，后进先出))
				stack.pop();
				return hasNext();
			} else {
				//有值返回true
				return true;
			}
		}
	}
	
	/*
	 * No longer needed as of Java 8
	 * 
	 * (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 *
	public void remove() {
		throw new UnsupportedOperationException();
	}
	*/
}


