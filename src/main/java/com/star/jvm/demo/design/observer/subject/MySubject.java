package com.star.jvm.demo.design.observer.subject;

import com.star.jvm.demo.design.observer.obs.MyObserver;

/**
 * 观察者接口
 */
public interface MySubject {

    /**
     * 注册
     * @param myObserver
     */
    void register(MyObserver myObserver);

    /**
     * 取消注册
     * @param myObserver
     */
    void removeRegister(MyObserver myObserver);

    /**
     * 通知所有观察者
     */
    void inform();

    /**
     * 更新数据
     * @param temp
     * @param humidity
     * @param pressure
     */
    void setMessage(float temp,float humidity,float pressure);
}
