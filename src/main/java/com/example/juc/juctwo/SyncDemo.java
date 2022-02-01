package com.example.juc.juctwo;

/**
 * @create 2022-02-01 18:02
 */
public class SyncDemo {
    Object lock;

    public SyncDemo() {

    }

    /*  public SyncDemo(Object lock){
            this.lock=lock;
        }*/
    public void demo(/*Object lock*/) {
        synchronized (this) {//ThreadA ThreadB
            //事务
//            this.lock = lock;
        }
    }

    public static void main(String[] args) {
        SyncDemo sd = new SyncDemo();
        new Thread(() -> sd.demo()).start();
        new Thread(() -> sd.demo()).start();
    }


    private App app=new App();
    public App getApp(){
        return app;
    }




}
