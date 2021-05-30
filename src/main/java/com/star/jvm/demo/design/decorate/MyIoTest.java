package com.star.jvm.demo.design.decorate;

import com.star.jvm.demo.design.decorate.io.LowCaseInputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * io装饰者测试类
 */
public class MyIoTest {

    public static void main(String[] args) throws IOException {
        LowCaseInputStream in = new LowCaseInputStream(new BufferedInputStream(new FileInputStream("E:\\学习相关\\设计模式\\myIoDecorator.txt")));
        int c = 0;
        while ((c = in.read())>=0){
            System.out.print((char) c);
        }
        testChar();
    }

    private static void testChar(){
        char c9 = '1';
        int num9 = c9 - '0';
        System.out.println();
        System.out.println(num9);
        int num10 = 1;
        char c10 = (char)(num10 + '0');
        System.out.println(c10);
    }
}
