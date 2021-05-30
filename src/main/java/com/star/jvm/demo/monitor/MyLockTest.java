package com.star.jvm.demo.monitor;

public class MyLockTest {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10*1000L);
        ModelA aa = new ModelA();
        aa.s1="123";
        aa.s2="456";
        for(int i = 0; i < 10; i++){
            Thread thread1 = new Thread(new ThreadModelOne(aa));
            thread1.setName("myThread1");
            thread1.start();
            Thread thread2 = new Thread(new ThreadModelTwo(aa));
            thread2.setName("myThread2");
            thread2.start();
        }
    }

}

class ModelA{
    public String s1;
    public String s2;
}

class ThreadModelOne implements Runnable{

    private ModelA model;

    public ThreadModelOne(ModelA model){
        this.model=model;
    }

    @Override
    public void run() {
        synchronized (model.s1){
            System.out.println("this is one s1");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("start one s2");
            synchronized (model.s2){
                System.out.println("this is one s2");
            }
        }

    }
}

class ThreadModelTwo implements Runnable{

    private ModelA model;

    public ThreadModelTwo(ModelA model){
        this.model=model;
    }

    @Override
    public void run() {
        synchronized (model.s2){
            System.out.println("this is one s2");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("start one s1");
            synchronized (model.s1){
                System.out.println("this is one s1");
            }
        }
    }
}