package com.star.jvm.demo.classinit;

public class MyParent {

    public static String parent = "parent";

    static {
        System.out.println("this is my parent");
    }
}
