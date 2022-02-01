package com.example.juc.juctwo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @create 2022-02-01 18:29
 */
public class App {
    public volatile static boolean stop=false;


    public static void main( String[] args ) throws InterruptedException {
        Thread t1=new Thread(()->{
            int i=0;
            while(!stop){ //condition 不满足
                i++;
            }
        });
        t1.start();
        Thread.sleep(1000);
        stop=true; //true


    }

    static int count;

    static AtomicInteger atomicInteger=new AtomicInteger(0);

    //序号. -> 序号重叠.

    static void incr(){
        atomicInteger.incrementAndGet();
//        count++;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        for(int i=0;i<1000;i++){
//            new Thread(App::incr).start();
//        }
//
//    }
}
