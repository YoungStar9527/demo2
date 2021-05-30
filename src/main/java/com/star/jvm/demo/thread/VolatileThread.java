package com.star.jvm.demo.thread;

public class VolatileThread implements Runnable{

    private String threadName="";

    private VolatileDomain volatileDomain=null;

    public VolatileThread(String threadName,VolatileDomain volatileDomain) {
        this.threadName = threadName;
        this.volatileDomain = volatileDomain;
    }

    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            volatileDomain.voExecuteCas();
        }
        System.out.println("VolatileThread is over:"+threadName);
    }
}
