package com.example.juc.jucone;

/**
 * @create 2021-11-06 20:25
 */
public class Testone {
    public static void main(String[] args) throws InterruptedException {
        concurrenry();
        serial();
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrenry" + time + ",b:" + b + ",a:" + a);

    }

    private static final long count = 1000L;

    private static void concurrenry() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; b < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrenry" + time + ",b:" + b);
    }

}
