package com.star.jvm.demo.design.iterator.dinermergercafe;

import java.util.Iterator;

/**
 * 侍者类，负责迭代菜单
 */
public class Waitress {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	Menu cafeMenu;

	/**
	 * 构造注入菜单
	 * @param pancakeHouseMenu
	 * @param dinerMenu
	 * @param cafeMenu
	 */
	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}

	/**
	 * 无参打印方法，打印所有菜单
	 */
	public void printMenu() {
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
		Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();

		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
		System.out.println("\nDINNER");
		printMenu(cafeIterator);
	}

	/**
	 * 有参打印方法，打印对应菜单
	 * @param iterator 菜单的迭代器
	 */
	private void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}

	/**
	 * 打印菜单中所有素食
	 */
	public void printVegetarianMenu() {
		System.out.println("\nVEGETARIAN MENU\n---------------");
		printVegetarianMenu(pancakeHouseMenu.createIterator());
		printVegetarianMenu(dinerMenu.createIterator());
		printVegetarianMenu(cafeMenu.createIterator());
	}

	/**
	 * 通过菜名遍历所有菜单，判断是否为素食
	 * @param name
	 * @return
	 */
	public boolean isItemVegetarian(String name) {
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
		if (isVegetarian(name, pancakeIterator)) {
			return true;
		}
		Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
		if (isVegetarian(name, dinerIterator)) {
			return true;
		}
		Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();
		if (isVegetarian(name, cafeIterator)) {
			return true;
		}
		return false;
	}

	/**
	 * 打印对应菜单中的素食
	 * @param iterator
	 */
	private void printVegetarianMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			if (menuItem.isVegetarian()) {
				System.out.print(menuItem.getName() + ", ");
				System.out.print(menuItem.getPrice() + " -- ");
				System.out.println(menuItem.getDescription());
			}
		}
	}

	/**
	 * 通过菜名遍历对应菜单，判断是否为素食
	 * @param name
	 * @param iterator
	 * @return
	 */
	private boolean isVegetarian(String name, Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			if (menuItem.getName().equals(name)) {
				if (menuItem.isVegetarian()) {
					return true;
				}
			}
		}
		return false;
	}
}

