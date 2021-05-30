package com.star.jvm.demo.classinit;

public interface Api {

    public static String str = "hello";

    public void t1();

    public  default  void t2(){
        System.out.println(str+" world");
    }

}
