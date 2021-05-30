package com.star.jvm.demo.classinit;

public class MyTest {

    static {
        System.out.println("this is my main");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //使用接口default方法1
//        Api api = new MyChild();
//        api.t2();
        //使用接口default方法2
//        Api api = (Api)(Class.forName("com.star.jvm.demo.classinit.MyChild").newInstance());
//        api.t2();
        //类初始化顺序经典案例
//        MyClassA classA = MyClassA.getInstance();
//        System.out.println("a=="+classA.getA());
//        System.out.println("b=="+classA.getB());
        //被动使用类案例1
        //System.out.println(MyChild.parent);
        //被动使用案例2
        //MyChild[] myChildrenArr = new MyChild[2];
        //被动使用案例3
        //System.out.println(MyChild.childFinalStr);
        System.out.println("totalMemory==="+Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println("freeMemory==="+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("maxMemory==="+Runtime.getRuntime().maxMemory()/1024/1024);
    }
}
