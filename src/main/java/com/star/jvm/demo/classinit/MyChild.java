package com.star.jvm.demo.classinit;

public class MyChild extends  MyParent implements Api{

    public final static String childFinalStr = "final child str";

    public  static String childStr = "final child str";

    static {
        System.out.println("this is myClhid");
    }

    @Override
    public void t1() {

    }
}
