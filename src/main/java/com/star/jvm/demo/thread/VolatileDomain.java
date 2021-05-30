package com.star.jvm.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDomain {

    private volatile int voNum;

    private  AtomicInteger race = new AtomicInteger(0);

    public void voExecute(){
        voNum++;
    }

    public void voExecuteCas(){
        race.incrementAndGet();
    }

    public int getVoNum() {
        return voNum;
    }

    public  AtomicInteger getRace() {
        return race;
    }
}
