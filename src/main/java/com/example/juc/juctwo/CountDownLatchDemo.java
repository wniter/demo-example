package com.example.juc.juctwo;

import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 *
 *
 */
public class CountDownLatchDemo extends Thread{

    static CountDownLatch countDownLatch=new CountDownLatch(100);

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new CountDownLatchDemo().start();
        }
        countDownLatch.countDown();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await(); //阻塞  3个线程 Thread.currentThread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO
        System.out.println("ThreadName:"+Thread.currentThread().getName());
    }




  /*  public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch =new CountDownLatch(3);
        new Thread(()->{
            System.out.println("Thread1");
            countDownLatch.countDown(); //3-1=2
        }).start();
        new Thread(()->{
            System.out.println("Thread2");
            countDownLatch.countDown();//2-1=1
        }).start();
        new Thread(()->{
            System.out.println("Thread3");
            countDownLatch.countDown();//1-1=0
        }).start();
        countDownLatch.await();
    }*/
}
