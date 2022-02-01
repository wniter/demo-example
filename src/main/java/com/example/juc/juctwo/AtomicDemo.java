package com.example.juc.juctwo;

import lombok.SneakyThrows;

/**
 * @create 2022-02-01 18:07
 */
public class AtomicDemo {
    private static int count = 0;

    public /* synchronized */ static void incr() throws Exception {
        synchronized (AtomicDemo.class) {
            Thread.sleep(1);
            count++;
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1000; i++) {
            //new thread(() ->{}).start
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    AtomicDemo.incr();
                }
            });
            Thread.sleep(5000);
            System.out.println("运行结果：" + count);
        }
    }
}
