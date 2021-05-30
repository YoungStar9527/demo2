package com.star.jvm.demo.design.proxy.javaproxy;
 
import java.lang.reflect.*;

/**
 * 动态代理类
 * 动态代理修改方法的行为
 */
public class OwnerInvocationHandler implements InvocationHandler { 
	Person person;
 
	public OwnerInvocationHandler(Person person) {
		this.person = person;
	}

	/**
	 * 自己调用，自己调用可以修改自己的属性，和获取信息
	 * 但是不能对自己评价，对自己评价直接抛出异常
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws IllegalAccessException
	 */
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws IllegalAccessException {
  
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(person, args);
   			} else if (method.getName().equals("setGeekRating")) {
				throw new IllegalAccessException();
			} else if (method.getName().startsWith("set")) {
				return method.invoke(person, args);
			} 
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } 
		return null;
	}
}
