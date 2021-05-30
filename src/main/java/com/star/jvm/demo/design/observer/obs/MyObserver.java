package com.star.jvm.demo.design.observer.obs;

/**
 * 气象观察者接口
 */
public interface MyObserver {

    /**
     * 主题通知时，调用此修改接口
     * @param temp 温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    void update(float temp,float humidity,float pressure);
}
