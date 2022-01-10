package com.star.jvm.demo.juc.lock;

public class ThreadTermination {

    /**
     * 执行线程
     */
    private Thread executeThread;

    /**
     *
     * @param task 发生阻塞的线程任务
     */
    public void execute(Runnable task) {
        executeThread = new Thread(() -> {
            Thread childThread = new Thread(task);

            // 子线程设置为守护线程
            childThread.setDaemon(true);

            childThread.start();
            try {
                // 强行执行子线程，使其进入休眠状态
                childThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executeThread.start();
    }

    /**
     *
     * @param mills 强制结束任务的时长阈值
     */
    public void shutdown(long mills) {
        long currentTime = System.currentTimeMillis();
        while (true) {
            if ((System.currentTimeMillis() - currentTime) >= mills) {
                System.out.println("任务超时，需要结束他!");
                executeThread.interrupt();
                break;
            }
        }
    }
    public static void main(String[] args) {
        ThreadTermination executor = new ThreadTermination();
        long start = System.currentTimeMillis();
        executor.execute(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown(1000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    public static void test1(){
        Thread thread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("i="+(i+1));
            }
        });
        thread.start();
        thread.interrupt();
        System.out.println("第一次调用thread.isInterrupted()："+thread.isInterrupted());
        System.out.println("第二次调用thread.isInterrupted()："+thread.isInterrupted());

        System.out.println("thread是否存活："+thread.isAlive());
    }

    public static void test2(){
        Thread td = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100000L);
                } catch (InterruptedException e) {
                    System.out.println("线程是否处于中断状态" + Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                    System.out.println("abc");
                }
                System.out.println("def");
            }
        });
        td.start();
        td.interrupt();
    }
}
