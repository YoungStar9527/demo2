package com.star.jvm.demo.asm;

import org.objectweb.asm.*;

/**
 * 通过asm实现简易aop记录时间
 */
public class MyClassVisitor extends ClassVisitor {
    public MyClassVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM7, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        cv.visit(version, access, name, signature, superName, interfaces);
    }


    /**
     * 重写对方法的操作实现aop
     * @param access
     * @param name
     * @param descriptor
     * @param signature
     * @param exceptions
     * @return
     */
    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = cv.visitMethod(access, name, descriptor, signature, exceptions);
        if( !"<init>".equals(name) && methodVisitor!=null){
            //为方法增加记录时间的功能
            methodVisitor = new MyMethodVisitor(methodVisitor);
        }
        return methodVisitor;
    }

    class MyMethodVisitor extends MethodVisitor{

        public MyMethodVisitor(MethodVisitor methodVisitor) {
            super(Opcodes.ASM7, methodVisitor);
        }

        /**
         * 方法的开始
         */
        @Override
        public void visitCode() {
            mv.visitCode();
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/star/jvm/demo/asm/MyTimeLogger", "startTime", "()V", false);
            Label label4 = new Label();
            mv.visitLabel(label4);
            mv.visitLineNumber(7, label4);
        }

        /**
         * 方法的执行中
         * @param opcode
         */
        @Override
        public void visitInsn(int opcode) {
            //判断对应方法执行流程，在retrun前，及抛出异常时添加对应代码记录时间
            if((opcode>=Opcodes.IRETURN && opcode <= Opcodes.RETURN)|| opcode==Opcodes.ATHROW){
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/star/jvm/demo/asm/MyTimeLogger", "endTime", "()V", false);
                Label label7 = new Label();
                mv.visitLabel(label7);
                mv.visitLineNumber(14, label7);
            }
            mv.visitInsn(opcode);
        }
    }
}
