package com.star.jvm.demo.design.proxy.jdk;

public class BookLessImpl implements BookLess {

    @Override
    public void lessBook() {
        System.out.println("借出图书方法。。。");
    }

}
