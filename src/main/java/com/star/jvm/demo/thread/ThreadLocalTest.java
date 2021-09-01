package com.star.jvm.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

    private static ThreadLocal<String>  threadLocal = new ThreadLocal<>();

    private static ThreadLocal<String>  threadLocalNew = new InheritableThreadLocal<>();

    private static ThreadLocal<byte[]>  threadLocalNewByte = new InheritableThreadLocal<>();

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    //

    public static void main(String[] args) {

        //test1();
//        threadLocalNew.set("test2==>帅哥");
//        test2("one-");
//        threadLocalNew.remove();
//        test2("two-");
//        test3(true);
//        test3(false);
//        test3(false);
//        test3(false);
//        System.out.println("out");
//        executorService.shutdown();
    }



    private static void test2(String str){
        Thread thOne = new Thread(()->{
            System.out.println(str+threadLocalNew.get());
        });
        Thread thTwo = new Thread(()->{
            System.out.println(str+threadLocalNew.get());
        });
        thOne.start();
        thTwo.start();
    }

    private static void test3(boolean flag){
        if(flag){
            threadLocalNew.set("test3==>帅哥");
        }
        //for (int i = 0;i < 10; i++){
            executorService.execute(()->{
                System.out.println(threadLocalNew.get());
            });
            //if(i>5){
                threadLocalNew.remove();
           // }
        //}
    }

    private static void test1(){
        threadLocal.set("test1==>帅哥");
        Thread thOne = new Thread(()->{
            System.out.println(threadLocal.get());
        });
        Thread thTwo = new Thread(()->{
            System.out.println(threadLocal.get());
        });
        thOne.start();
        thTwo.start();
    }


}
