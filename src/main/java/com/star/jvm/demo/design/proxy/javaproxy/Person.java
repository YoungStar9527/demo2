package com.star.jvm.demo.design.proxy.javaproxy;

/**
 * 人物接口，所有人物实现改接口
 */
public interface Person {
 
	String getName();
	String getGender();
	String getInterests();
	int getGeekRating();
 
    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setGeekRating(int rating); 
 
}
