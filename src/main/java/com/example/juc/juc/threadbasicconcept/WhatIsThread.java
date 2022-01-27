package com.example.juc.juc.threadbasicconcept;

import java.util.concurrent.TimeUnit;

/**
 * @create 2022-01-27 7:17
 */
public class WhatIsThread {
    private static final int constant = 10;

    private static class T extends Thread {
        @Override
        public void run() {
            //事务
            //eg：1到10
            for (int i = 0; i < constant;i++){
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("finish-T");
        }
    }

    public static void main(String[] args) {

        new T().start();
        for (int i = 0; i < constant;i++){
            try {
                //执行一个{@link线程#sleep(long, int)线程。 睡眠}使用此时间单位。
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("finish-main");
    }

}
