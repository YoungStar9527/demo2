package com.star.jvm.demo.design.adapter;

import com.star.jvm.demo.design.adapter.intfa.Duck;
import com.star.jvm.demo.design.adapter.intfa.impl.WildTurkey;

/**
 * 适配器测试类
 */
public class AdapterDriver {

    public static void main(String[] args) {
        //通过适配器将火鸡适配鸭子
        Duck duck = new DuckAdaper(new WildTurkey());
        //鸭子叫，实际时火鸡
        duck.quack();
        //鸭子飞，实际是火鸡
        duck.fly();
    }
}
