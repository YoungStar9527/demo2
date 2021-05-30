package com.star.jvm.demo.thread;

/**
 * volatile变量自增运算测试
 *
 * @author zzm
 */
public class VolatileTest {

    public static void main(String[] args) throws InterruptedException {
        VolatileDomain v = new VolatileDomain();
        Thread t1 = new Thread(new VolatileThread("t1",v));
        Thread t2 = new Thread(new VolatileThread("t2",v));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("num=="+v.getRace());
    }
}
