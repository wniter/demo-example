package com.example.juc.jucone.TestOne;

/**
 * @create 2021-11-08 23:59
 */
public class synchronizationTest {
    //数据中的竞争问题
    //两条以上的线程访问同一个内存区域
    //eg：
    private synchronizationTest Test1() {
        synchronizationTest synchronizationtest = new synchronizationTest();
        if (synchronizationtest == null) {
            synchronizationtest = new synchronizationTest();
        }
        return synchronizationtest;
    }

    //缓存变量
    //为了提升性能，JVM在处理器中缓存变量，不会依赖主存，每条线程都会有自己的变量拷贝，当线程写入这个变量的时候，就是写入自己的拷贝，
    //其他线程不太可能看到自己的变量的拷贝发生
    private void Test2() {
    }
//档调用Sleep时，当前线程不会释放锁
    //同步   竞争问题
    //使用synchronized 关键字
    //eg:对象在引用id时，会不得不等待执行的线程释放锁
    private synchronized int getID() {
        int counter = 0;
        return counter++;
    }
    //同步代码块
//   synchronized (Object){
//
//    }

}
