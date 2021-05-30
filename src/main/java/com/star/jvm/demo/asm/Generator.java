package com.star.jvm.demo.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 执行asm代码修改class文件
 * ps:asm修改代码最好不添加变量影响局部变量表，因为局部变量表的修改会导致运行异常（局部变量表类型异常等问题）
 * 一般使用静态方法等方式实现asm的动态注入class文件
 */
public class Generator {

    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("com/star/jvm/demo/asm/Cc");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassVisitor cv = new MyClassVisitor(cw);
        cr.accept(cv,ClassReader.SKIP_DEBUG);
        byte[] bytes = cw.toByteArray();
        //输出
        File file = new File("target/classes/com/star/jvm/demo/asm/Cc.class");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
        System.out.println("success");
    }
}
