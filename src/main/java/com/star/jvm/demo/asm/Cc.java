package com.star.jvm.demo.asm;

public class Cc {

    public void m1(){
        System.out.println("asm method ----->");
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
