package com.star.jvm.demo.design.factory;

import com.star.jvm.demo.design.factory.abs.AbsPizzaStore;
import com.star.jvm.demo.design.factory.abs.PizzaAbs;
import com.star.jvm.demo.design.factory.model.ChicagoPizzaStore;
import com.star.jvm.demo.design.factory.model.NYPizzaStore;
import com.star.jvm.demo.design.factory.model.SuperPizzaStore;
import com.star.jvm.demo.design.factory.simple.SimpleFactory;
import com.star.jvm.demo.design.factory.simple.SimplePizzaStore;
import com.star.jvm.demo.design.factory.source.Pizza;
import com.star.jvm.demo.design.factory.source.PizzaStore;

/**
 * 披萨测试类
 */
public class PizzaTestDrive {

    /**
     * 原始披萨
     */
    private static void sourceDriver(){
        PizzaStore pizzaStore = new PizzaStore();
        Pizza cheese = pizzaStore.orderPizza("cheese");
        System.out.println(cheese.toString());
    }

    /**
     * 简单工厂披萨
     */
    private  static void simpleDriver(){
        SimplePizzaStore sim = new SimplePizzaStore(new SimpleFactory());
        Pizza pepperoni = sim.orderPizza("pepperoni");
        System.out.println(pepperoni.toString());
    }

    /**
     * 工厂模式披萨
     */
    private static void modelDriver(){
        SuperPizzaStore chi = new ChicagoPizzaStore();
        Pizza chiClam = chi.orderPizza("clam");
        System.out.println(chiClam);
        SuperPizzaStore ny = new NYPizzaStore();
        Pizza nyClam = ny.orderPizza("clam");
        System.out.println(nyClam);
    }

    /**
     * 工厂模式 结合抽象工厂模式 披萨
     */
    private static void modelAbsDriver(){
        AbsPizzaStore storeNy = new com.star.jvm.demo.design.factory.abs.NYPizzaStore();
        PizzaAbs veggieNy = storeNy.orderPizza("veggie");
        System.out.println(veggieNy.toString());
        AbsPizzaStore storeChi = new com.star.jvm.demo.design.factory.abs.ChicagoPizzaStore();
        PizzaAbs veggieChi = storeChi.orderPizza("veggie");
        System.out.println(veggieChi.toString());
    }

    public static void main(String[] args) {
        //sourceDriver();
        //simpleDriver();
        //modelDriver();
        modelAbsDriver();
    }
}
