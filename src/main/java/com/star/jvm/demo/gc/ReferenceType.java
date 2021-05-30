package com.star.jvm.demo.gc;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;

public class ReferenceType {

    private static ReferenceQueue<User> rq = new ReferenceQueue<>();

    private static void printQueue(String str){
        Reference<? extends User> obj = rq.poll();
        if(obj!=null){
            System.out.println("the gc object reference=="+str+"="+obj.get());
        }
    }

    private static void testSoftReference()throws Exception{
        List<SoftReference<User>> list = new ArrayList<>();
        for(int i = 0;i < 10; i++){
            SoftReference<User> sr = new SoftReference<>(new User("soft"+i),rq);
            System.out.println("now the soft user==="+sr.get());
            list.add(sr);
        }
        System.gc();
        Thread.sleep(1000L);
    }

    private static void tesWeakReference()throws Exception{
        List<WeakReference<User>> list = new ArrayList<>();
        for(int i = 0;i < 10; i++){
            WeakReference<User> sr = new WeakReference<>(new User("weak"+i),rq);
            System.out.println("now the weak user==="+sr.get());
            list.add(sr);
        }
        System.gc();
        Thread.sleep(1000L);
    }

    private static void tesPhantomReference()throws Exception{
        List<PhantomReference<User>> list = new ArrayList<>();
        for(int i = 0;i < 10; i++){
            PhantomReference<User> sr = new PhantomReference<>(new User("phantom"+i),rq);
            System.out.println("now the phantom user==="+sr.get());
            list.add(sr);
        }
        System.gc();
        Thread.sleep(1000L);
    }


    public static void main(String[] args) throws Exception {
        Reference<? extends User> obj = null;
        tesWeakReference();
        while ((obj=rq.poll())!=null){
            System.out.println(obj);
        }
        tesPhantomReference();
        while ((obj=rq.poll())!=null){
            System.out.println(obj);
        }
        testSoftReference();
        while ((obj=rq.poll())!=null){
            System.out.println(obj);
        }
    }
}
