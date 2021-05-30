package com.star.jvm.demo.gc;

public class HelpSelf {
    private static HelpSelf hs = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("now in finalize===");
        hs = this;
    }

    public static void main(String[] args) throws InterruptedException {
        hs = new HelpSelf();
        hs = null;
        System.gc();
        Thread.sleep(1000L);
        System.out.println(hs);
        hs = null;
        System.gc();
        Thread.sleep(1000L);
        System.out.println(hs);
    }
}
