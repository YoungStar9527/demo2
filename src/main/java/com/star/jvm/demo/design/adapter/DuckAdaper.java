package com.star.jvm.demo.design.adapter;

import com.star.jvm.demo.design.adapter.intfa.Duck;
import com.star.jvm.demo.design.adapter.intfa.Turkey;

/**
 * 鸭子适配器
 */
public class DuckAdaper implements Duck {

    private Turkey turkey;

    /**
     * 传入火鸡，适配鸭子
     * @param turkey
     */
    public DuckAdaper(Turkey turkey) {
        this.turkey = turkey;
    }

    /**
     * 适配飞行行为
     */
    @Override
    public void fly() {
        //火鸡飞的比较近，需要飞五次
        for(int i = 0;i < 5;i++){
            turkey.fly();
        }

    }

    /**
     * 适配叫声
     */
    @Override
    public void quack() {
        turkey.gobble();
    }
}
