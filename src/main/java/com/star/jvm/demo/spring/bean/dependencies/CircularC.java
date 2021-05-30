package com.star.jvm.demo.spring.bean.dependencies;

public class CircularC {

    private CircularA circularA;

    public CircularA getCircularA() {
        return circularA;
    }

    public void setCircularA(CircularA circularA) {
        this.circularA = circularA;
    }
}
