package com.star.jvm.demo.juc.finalclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefensiveReplicaDemo {

    private final List<Integer> data = new ArrayList<>();

    private final List<Integer> dataFinal = new ArrayList<>();


    public DefensiveReplicaDemo() {
        data.add(1);
        data.add(2);
        data.add(3);
        dataFinal.add(1);
        dataFinal.add(2);
        dataFinal.add(3);
    }

    public List<Integer> getData() {
        return data;
    }

    /**
     * 防御性复制，如果修改这个集合就会抛出异常
     * @return
     */
    public  List<Integer> getDataFinal() {
        return Collections.unmodifiableList(new ArrayList<>(dataFinal));
    }

    public static void main(String[] args) {
        DefensiveReplicaDemo defensiveReplicaDemo = new DefensiveReplicaDemo();
        List<Integer> data = defensiveReplicaDemo.getData();
        List<Integer> dataFinal = defensiveReplicaDemo.getDataFinal();
        data.add(4);
        System.out.println(defensiveReplicaDemo.getData());
        //这个add方法会抛出异常
        dataFinal.add(4);
        System.out.println(defensiveReplicaDemo.getDataFinal());
    }
}
