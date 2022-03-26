package com.example.coccurrentdemo.common;

public class ThreadName {

    private static void sleepMilliSeconds(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static Object getCurThreadName() {
        return Thread.currentThread().getName();
    }
}
