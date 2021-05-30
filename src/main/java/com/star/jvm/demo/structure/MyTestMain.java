package com.star.jvm.demo.structure;

public class MyTestMain {

    public static void main(String[] args) {
//        MyStack stack = new MyStack(4);
//        testMatch(stack);
//        System.out.println(stack.isEmpty());
        testPriorityQue();
    }

    public static void testMatch(MyStack stack){
        String str = "12<a[b{c}]>";
        char[] cha = str.toCharArray();
        for(char c : cha){
            switch (c) {
                case '{':
                case '[':
                case '<':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case '>':
                    if(!stack.isEmpty()){
                        char ch = stack.pop().toString().toCharArray()[0];
                        if((c=='}' && ch != '{') || (c==']' && ch != '[') || (c==')' && ch != '(')){
                            System.out.println("Error:"+ch+"-"+c);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public static void testPriorityQue(){
        PriorityQue priorityQue = new PriorityQue(10);
        priorityQue.insert(5);
        priorityQue.insert(8);
        priorityQue.insert(3);
        priorityQue.insert(1);
        priorityQue.insert(9);
        int remove = priorityQue.remove();
        System.out.println(remove);
        System.out.println(priorityQue.peekMin());
    }
}
