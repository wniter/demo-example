package com.example.juc.juctwo;

/**
 * @create 2022-02-01 18:30
 */
public class StartRule {
    static int x=0;

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            //use x=10
        });

        x=10;

        t1.start();
    }
}
