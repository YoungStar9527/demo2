package com.star.jvm.demo.execute;

public class MyTest1 {

    public int add(int a,int b){
        int c = a + b;
        Long d = 1L;
        return a+b+c;
    }

    public static int addSt(int a,int b){
        int c = a + b;
        return a+b+c;
    }

    public static void main(String[] args) {
            byte[] bytes = new byte[1024*1024*2];
        bytes = null;
        System.gc();
        System.out.println("totalMemory==="+Runtime.getRuntime().totalMemory()/1024.0/1024.0);
        System.out.println("freeMemory==="+Runtime.getRuntime().freeMemory()/1024.0/1024.0);
        System.out.println("maxMemory==="+Runtime.getRuntime().maxMemory()/1024.0/1024.0);
    }
}
