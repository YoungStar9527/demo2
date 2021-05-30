package com.star.jvm.demo.classinit;

public class MyTestStack {

    private int num = 0;

    private int callMe(int a){
        ++num;
        return callMe(a+num);
    }

    public static void main(String[] args) {
        MyTestStack myTestStack = new MyTestStack();
        try {
            myTestStack.callMe(1);
        }catch (Throwable e){
            System.out.println(myTestStack.num);
            e.printStackTrace();
        }
    }
}
