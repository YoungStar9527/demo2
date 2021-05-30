package com.star.jvm.demo.asm;

/**
 * aop工具类
 */
public class MyTimeLogger {

    private static Long time = 0L;

    public  static void startTime(){
        time = System.currentTimeMillis();
    }

    public  static void endTime(){
        System.out.println("time all=="+(System.currentTimeMillis()-time));
    }
}
