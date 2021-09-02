package com.star.jvm.demo.juc.finalclass;

import java.util.HashMap;
import java.util.Map;

public class CarLocatTracker {

    private Map<String,Location> locationMap = new HashMap<>();

    private Map<String,LocationFinal> locationFinalMap = new HashMap<>();

    private void updateCarLocation(String code,double x,double y){
        locationMap.get(code).setXY(x,y);
    }

    private void updateCarLocationFinal(String code,LocationFinal locationFinal){
        locationFinalMap.put(code,locationFinal);
    }

}
