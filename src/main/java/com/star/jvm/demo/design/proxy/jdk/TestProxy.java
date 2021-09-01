package com.star.jvm.demo.design.proxy.jdk;

public class TestProxy {

    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();
        BookLess bookLess = (BookLess) proxy.bind(new BookLessImpl());
        bookLess.lessBook();
    }

}