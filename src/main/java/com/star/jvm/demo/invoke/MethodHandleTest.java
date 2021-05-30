package com.star.jvm.demo.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 动态类型语言支持(方法句柄(指针调用))
 */
public class MethodHandleTest {

    static class ClassA{

        public void println(String str){
            System.out.println("ClassA:"+str);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis()%2==0?System.out:new ClassA();
        getPrintlnMH(obj).invokeExact("帅哥");
    }

    /**
     * 动态类型方法调用
     * @param reveiver 动态类型变量
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     */
    private static MethodHandle getPrintlnMH(Object reveiver) throws NoSuchMethodException, IllegalAccessException {
        //获取MethodType实例，第一个参数-返回值类型，第二个-N个为参数类型
        MethodType mt = MethodType.methodType(void.class,String.class);
        //lookup()这句的作用是在指定类中查找符合给定的方法 名称、方法类型，并且符合调用权限的方法句柄，bindTo()接收对象
        return MethodHandles.lookup().findVirtual(reveiver.getClass(),"println",mt).bindTo(reveiver);
    }
}
