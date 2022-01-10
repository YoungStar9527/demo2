package com.star.jvm.demo.juc.lock;

public class DeadLock02 {


    private static class SingleTonHoler{
        private static Allocator INSTANCE = new Allocator();
    }

    public static Allocator getInstance(){
        return SingleTonHoler.INSTANCE;
    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

    private static void test1(){
        Account a = new Account();
        Account b = new Account();
        a.transfer(b,100);
        b.transfer(a,200);
    }

    private static void test2(){
        Account a = new Account();
        Account b = new Account();
        Thread t1 = new Thread(()->{
            a.transfer(b,100);
        });
        Thread t2 = new Thread(()->{
            b.transfer(a,200);
        });
        t1.start();
        t2.start();
    }
}
