package com.example.juc.jucone.TestOne;

/**
 * @create 2021-11-07 23:02
 */
public class CreateThread {
    //create Thread
    private void Test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //perform some work
                System.out.println("hello world");
            }
        };
        Thread ts = new Thread(r);
        ts.start();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //perform some work
                System.out.println("hello world 2!");
            }
        }, "thread 2");
        System.out.println(thread.getName());
    }

    //判断一条线程是否位活的
    private void Test2() {
        Thread ts = new Thread();
        ts.isAlive();
        //获取一条线程的执行状态
        ts.getStackTrace();
        //        NEW：该状态下线程还没有开始执行。
//        RUNNABLE:该状态下线程正在JVM中执行
//        BLOCKED:该状态下线程被阻塞并等待个监听锁
//        WAITING:该状态下线程无限期地等待另外一条线程执行特定的操作。
//        TIMED WAITING:该状态下线程在特定的时间内等待另外一条线程执行某种操作。
//        TERMINATED:该状态下线程已经退出。
        //判断是否为守护线程
        ts.isDaemon();
        //设置守护线程
        ts.setDaemon(true);
        //启动线程
        ts.start();
    }

    //中断线程
    private void Test3() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                int count = 0;
                while (!Thread.interrupted()) {
                    System.out.println(name + ":" + count++);
                }
            }
        };
        Thread thread001 = new Thread(runnable, "thread001");
        Thread thread002 = new Thread(runnable, "thread002");
        thread001.start();
        thread002.start();

        while (true) {
            double n = Math.random();
            if (n >= 0.499999999999 && n <= 0.5000000001) {
                break;
            }
        }
        thread001.interrupt();
        thread002.interrupt();
    }
//等待线程
//            •	void join(）： 无限期地等待直至该线程死亡。 当任意线程中断当前线程的时候，InterruptedException 就会抛出。如果该异常被抛出，该线程的中断状态 就会被清除。
//            •	void join(long millis)： 该线程死亡之前最多等待 millis 毫秒。如果传递 0 作为参数就会无限期地等待 join() 其实就调用了 join(0)方法。
//    如果millis 是负数，那么就会导致 IllegalArgument Exception 被抛出。 当任意线程中断了当前线程， 就会导致Interrupted Exception 被抛出，如果该异常被抛出， 该线程的中断 状态会被清除。
//            •	void join(long millis, int nanos) ： 该线程死亡之前最多等待millis 毫秒加 nanos 纳秒。 当 millis 是负数、 nanos 是负数或者nanos
//        大千 999999 的时候，会导致 Illega􀀗ArgumentException 被抛出。当任意线程中断了当前线程，就会导致 InterruptedException被抛出，如果该异常被抛出， 该线程的中断状态会被清除。
    //睡眠线程
//    •	void sleep(long millis)：睡眠millis毫秒数。线程睡眠的实际 的毫秒数取决于系统定时器和调度器的精度。
//    如果millis是负数，那么就会导致IllegalArgumentException被抛出。当任意线程中断了当前线程，就会导致InterruptedException被抛出，如果该异常被抛出，该线程的中断状态会被清除。
//            •	void sleep(long millis, int nanos)： 睡眠 millis 毫秒数和 nanos纳秒数。实际睡眠的毫秒数和纳秒数取决千系统定时器和调度器的精度。当millis是负数，
//    nanos是负数或者nanos大于999999 的时候， 会导致 IllegalArgumentException 被抛出。 当任意线程中断了当前线程，就会导致InterruptedException被抛出，如果该异常被抛出， 该线程的 中断状态会被清除。
    public static void main(String[] args) {
        //new CreateThread().Test3();
    }

}
