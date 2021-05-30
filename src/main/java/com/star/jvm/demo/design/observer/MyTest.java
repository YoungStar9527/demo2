package com.star.jvm.demo.design.observer;

import com.star.jvm.demo.design.observer.obs.MyObserver;
import com.star.jvm.demo.design.observer.obs.impl.HotWeather;
import com.star.jvm.demo.design.observer.obs.impl.NowWeather;
import com.star.jvm.demo.design.observer.subject.MySubject;
import com.star.jvm.demo.design.observer.subject.impl.WeatherData;

public class MyTest {
    public static void main(String[] args) {
        MySubject mySubject = new WeatherData();
        MyObserver observerOne = new HotWeather(mySubject);
        MyObserver observerTwo = new NowWeather(mySubject);
        mySubject.setMessage(20F,72F,1032f);
    }
}
