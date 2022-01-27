package com.example.juc.juc.threadbasicconcept;

/**
 * @create 2022-01-27 7:27
 */
//创建线程的三种方式
//1.extends Thread
//2.implements runnable
//3。创建线程池
public class HowToCreateThread {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    private static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        System.out.println("--------------");
        new Thread(()->{
            System.out.println("Hello Lambda!");
        }).start();
    }
}
