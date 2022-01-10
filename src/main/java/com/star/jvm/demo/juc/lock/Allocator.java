package com.star.jvm.demo.juc.lock;

import java.util.ArrayList;
import java.util.List;

public class Allocator {

    private List<Object> als = new ArrayList<Object>();

    // 一次性申请所有资源
    synchronized boolean apply(Object from, Object to){
        if(als.contains(from) || als.contains(to)){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        } else {
            als.add(from);
            als.add(to);
        }
        return true;
    }
    synchronized void clean(Object from, Object to){
        als.remove(from);
        als.remove(to);
        notifyAll();
    }
}
