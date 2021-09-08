package com.star.jvm.demo.juc.lock;

public class DeadLock02 {


    private static class SingleTonHoler{
        private static Allocator INSTANCE = new Allocator();
    }

    public static Allocator getInstance(){
        return SingleTonHoler.INSTANCE;
    }

    public static void main(String[] args) {
        Account a = new Account();
        Account b = new Account();
        a.transfer(b,100);
        b.transfer(a,200);
    }
}
