package com.star.jvm.demo.classloader;

public class ClassLoaderStudy {

    {
        System.out.println();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //类加载器的关系
        String aa = "";
        System.out.println("str Classloader=="+aa.getClass().getClassLoader());
        Class<?> aClass = Class.forName("java.sql.Driver");
        System.out.println("driver Classloader=="+aClass.getClassLoader());
        System.out.println("driver Classloader parent=="+aClass.getClassLoader().getParent());
        //ss node = new ss();
//        System.out.println("asd Classloader  =="+node.getClass().getClassLoader());
//        System.out.println("asd Classloader parent =="+node.getClass().getClassLoader().getParent());
//        System.out.println("asd Classloadeparent parent r== "+node.getClass().getClassLoader().getParent().getParent());
        //自定义类记载器
        MyClassLoader myClassLoader = new MyClassLoader("myClassloader1");
        Class cls1 = myClassLoader.loadClass("com.star.jvm.demo.classloader.ss");
        System.out.println("cls1 class loader =="+cls1.getClassLoader());
        System.out.println("cls1 class loader parent =="+cls1.getClassLoader().getParent());
        //被破坏的双亲委派模型
        Class<?> driverManager = Class.forName("java.sql.DriverManager");
        System.out.println("driverManager class loader =="+driverManager.getClassLoader());
        Class<?> mysqlDriver = Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("mysqlDriver class loader =="+mysqlDriver.getClassLoader());
    }
}
