package com.star.jvm.demo.design.proxy.javaproxy;
 
import java.lang.reflect.*;

/**
 * 动态代理类
 * 动态代理修改方法的行为
 */
public class NonOwnerInvocationHandler implements InvocationHandler { 
	Person person;
 
	public NonOwnerInvocationHandler(Person person) {
		this.person = person;
	}

	/**
	 * 其他人调用，其他人调用可以获取信息，和评价
	 * 但是不能修改信息
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
				return method.invoke(person, args);
			} else if (method.getName().startsWith("set")) {
				throw new IllegalAccessException();
			} 
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } 
		return null;
	}
}
