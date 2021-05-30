package com.star.jvm.demo.monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MemoryMonitor {

    public static void main(String[] args) throws InterruptedException, IOException {
        Thread.sleep(20*1000L);
        List list = new ArrayList<>();
        for(int i = 0;i < 10000;i++){
            if(i%10==0){
                Thread.sleep(100L);
            }
            list.add(new TestA());
        }
        System.out.println("over");
        BufferedReader buffRea = new BufferedReader(new InputStreamReader(System.in));
        buffRea.readLine();
    }

}
class TestA {
    private byte[] bytes = new byte[100*1024];
}