package com.star.jvm.demo.juc.lock;

public class Account {

    private Allocator actr = DeadLock02.getInstance();
    private int balance;
    void transfer(Account target, int amt){
        //这个while是自循环，跳出while循环才会执行后续的try代码
        //while(!actr.apply(this, target));
        actr.apply(this, target);
            try{
                synchronized(this){
                    System.out.println(this.toString()+" lock obj1");
                    synchronized(target){
                        System.out.println(this.toString()+" lock obj2");
                        if (this.balance > amt){
                            this.balance -= amt;
                            target.balance += amt;
                        }
                    }
                }
            } finally {
                //执行完后，再释放持有的资源
                actr.clean(this, target);
            }
    }

}
