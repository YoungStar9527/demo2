package com.star.jvm.demo.spring.bean.dependencies;

public class CircularB {

    private CircularC circularC;

    public CircularC getCircularC() {
        return circularC;
    }

    public void setCircularC(CircularC circularC) {
        this.circularC = circularC;
    }
}
