package com.example.juc.juctwo;

/**
 * @create 2022-02-01 17:31
 */
public class Test implements Runnable{
    //中断标志
    private static volatile boolean isRunning = false;

    @Override
    public void run() {
        while(!isRunning){ //!true
            //TODO
        }

    }

    public static void main(String[] args) {
        System.out.println("test");

        Thread thread=new Thread();


        thread.interrupt();//isRunning=true;
    }
}
