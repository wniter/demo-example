package com.example.juc.juctwo;

/**
 * @create 2022-02-01 18:08
 */
public class WaitNotifyDemo {
    public static void main(String[] args) {
        Object lock = new Object();
        new ThreadA(lock).start();
        new ThreadB(lock).start();
    }
}
