package com.star.jvm.demo.thread;

public class MyTest {

    private static int a = 0;
    private static int b = 0;
    private static int x = 0;
    private static int y = 0;

    private static void addA(){
        byte[] bb = new byte[10000];
        for(int i = 0;i < 10000;i++){
            bb[i]=1;
        }
        a = 1;
    }

    private static void addB(){
        byte[] bb = new byte[10000];
        for(int i = 0;i < 10000;i++){
            bb[i]=1;
        }
        b = 2;
    }

//    public static void main(String[] args) throws InterruptedException {
//        for(int i = 0;i < 100000;i++){
//            a=0;
//            b=0;
//            x=0;
//            y=0;
//            Thread t1 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    addA();
//                    x = b;
//                }
//            });
//            Thread t2 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    addB();
//                    y = a;
//                }
//            });
//            t1.start();
//            t2.start();
//            t1.join();
//            t2.join();
//            if(x==0&&y==0){
//                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//            }
//            System.out.println("i="+i+"; x="+x+"; y="+y);
//        }
//
//    }

    //public static AtomicInteger num = new AtomicInteger(0);

    public volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            for (int i = 0; i < 1000000000; i++) {
                //num.getAndAdd(1);
                num++;
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("num = " + num);
    }
}
