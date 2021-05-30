package com.star.jvm.demo.design.observer.subject.impl;


import com.star.jvm.demo.design.observer.obs.MyObserver;
import com.star.jvm.demo.design.observer.subject.MySubject;

import java.util.ArrayList;
import java.util.List;

/**
 * 气象主题实现类
 */
public class WeatherData implements MySubject {

    private float temp;

    private float humidity;

    private float pressure;

    private List<MyObserver> observerList;

    public WeatherData() {
        observerList = new ArrayList<>();
    }

    @Override
    public void register(MyObserver myObserver) {
        observerList.add(myObserver);
    }

    @Override
    public void removeRegister(MyObserver myObserver) {
        int i = observerList.indexOf(myObserver);
        observerList.remove(i);
    }

    @Override
    public void inform() {
        for (MyObserver myObserver : observerList) {
            myObserver.update(temp,humidity,pressure);
        }
    }

    @Override
    public void setMessage(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        inform();
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
