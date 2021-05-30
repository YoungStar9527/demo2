package com.star.jvm.demo.gc;

public class User {

    private byte[] bs = new byte[106*1024];

    private String userId;

    public User(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("now finalize userId=="+userId);
    }

    public static Integer parseInt(String s) {
        return (s == null) ?
                (Integer) null : Integer.valueOf(s);
    }
    public static void main(String[] args) {
        String s = null;
        System.out.println((Integer)null);
    }
}
