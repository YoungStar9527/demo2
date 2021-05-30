package com.star.jvm.demo.design.observer.obs.impl;

import com.star.jvm.demo.design.observer.obs.MyMessage;
import com.star.jvm.demo.design.observer.obs.MyObserver;
import com.star.jvm.demo.design.observer.subject.MySubject;

/**
 * 当前天气信息布告板
 */
public class NowWeather implements MyMessage,MyObserver {

    private float temp;

    private float humidity;

    private float pressure;

    public NowWeather(MySubject mySubject) {
        mySubject.register(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "NowWeather{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }
}
