package com.star.jvm.demo.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExecutor =
                new ThreadPoolExecutor(10,20,60,
                        TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(),
                        Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        for(int i =0;i<1000;i++){
            Thread.sleep(100);
            poolExecutor.execute(()->{
                System.out.println("我是你的爸爸");
            });
        }
        poolExecutor.shutdown();
    }
}
