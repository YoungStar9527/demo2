package com.star.jvm.demo.design.observer.obs.impl;

import com.star.jvm.demo.design.observer.obs.MyMessage;
import com.star.jvm.demo.design.observer.obs.MyObserver;
import com.star.jvm.demo.design.observer.subject.MySubject;

/**
 * 热度指数布告板
 */
public class HotWeather implements MyMessage,MyObserver {

    private float temp;

    private float humidity;

    public HotWeather(MySubject mySubject) {
        mySubject.register(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println(computeHeatIndex());
    }

    /**
     * 热度指数对应公式
     * @return
     */
    private float computeHeatIndex() {
        float t = temp;
        float rh = humidity;
        float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
                (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
                (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));
        return index;
    }

}
