package com.star.jvm.demo.test;

public class MyThreadTestOne {

    private  static boolean flag = false;

    private   static int i =0;

    public  static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (!flag){
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                woca();
            }
            System.out.println("flag");
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            flag=true;
        }).start();
        System.out.println(i);
    }

    private static  void woca(){
        i++;
    }
}
