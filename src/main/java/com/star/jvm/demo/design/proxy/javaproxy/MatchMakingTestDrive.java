package com.star.jvm.demo.design.proxy.javaproxy;

import java.lang.reflect.*;
import java.util.*;

/**
 * 保护代理测试类
 */
public class MatchMakingTestDrive {
	HashMap<String, Person> datingDB = new HashMap<String, Person>();
 	
	public static void main(String[] args) {
		MatchMakingTestDrive test = new MatchMakingTestDrive();
		test.drive();
	}
 
	public MatchMakingTestDrive() {
		initializeDatabase();
	}

	/**
	 * 通过代理类来获取对象，不同代理类保护不同的行为
	 */
	public void drive() {
		Person joe = getPersonFromDatabase("Joe Javabean"); 
		Person ownerProxy = getOwnerProxy(joe);
		System.out.println("Name is " + ownerProxy.getName());
		ownerProxy.setInterests("bowling, Go");
		System.out.println("Interests set from owner proxy");
		try {
			ownerProxy.setGeekRating(10);
		} catch (Exception e) {
			System.out.println("Can't set rating from owner proxy");
		}
		System.out.println("Rating is " + ownerProxy.getGeekRating());

		Person nonOwnerProxy = getNonOwnerProxy(joe);
		System.out.println("Name is " + nonOwnerProxy.getName());
		try {
			nonOwnerProxy.setInterests("bowling, Go");
		} catch (Exception e) {
			System.out.println("Can't set interests from non owner proxy");
		}
		nonOwnerProxy.setGeekRating(3);
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy.getGeekRating());
	}

	/**
	 * 通过动态代理修改对象方法，实现保护代理模式
	 * 不同的的动态代理类，调整对应的方法访问，不允许访问的方法直接抛出异常
	 * @param person
	 * @return
	 */
	Person getOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
            	person.getClass().getClassLoader(),
            	person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
	}

	/**
	 * 通过动态代理修改对象方法，实现保护代理模式
	 * 不同的的动态代理类，调整对应的方法访问，不允许访问的方法直接抛出异常
	 * @param person
	 * @return
	 */
	Person getNonOwnerProxy(Person person) {

        return (Person) Proxy.newProxyInstance(
            	person.getClass().getClassLoader(),
            	person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
	}

	/**
	 * 获取map中对应对象
	 * @param name
	 * @return
	 */
	Person getPersonFromDatabase(String name) {
		return (Person)datingDB.get(name);
	}

	/**
	 * 初始化对象
	 */
	void initializeDatabase() {
		Person joe = new PersonImpl();
		joe.setName("Joe Javabean");
		joe.setInterests("cars, computers, music");
		joe.setGeekRating(7);
		datingDB.put(joe.getName(), joe);

		Person kelly = new PersonImpl();
		kelly.setName("Kelly Klosure");
		kelly.setInterests("ebay, movies, music");
		kelly.setGeekRating(6);
		datingDB.put(kelly.getName(), kelly);
	}
}
