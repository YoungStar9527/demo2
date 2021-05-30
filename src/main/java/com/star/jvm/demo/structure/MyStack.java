package com.star.jvm.demo.structure;

public class MyStack {
    private Object[] array;
    private int maxSize;
    private int top;

    public MyStack(int size){
        this.maxSize = size;
        array = new Object[size];
        top = -1;
    }

    //压入数据
    public void push(Object value){
        if(top < maxSize-1){
            array[++top] = value;
        }
    }

    //弹出栈顶数据
    public Object pop(){
        return array[top--];
    }

    //访问栈顶数据
    public Object peek(){
        return array[top];
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return (top == -1);
    }

    //判断栈是否满了
    public boolean isFull(){
        return (top == maxSize-1);
    }


}
