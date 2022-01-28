package com.example.juc.jucone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @create 2021-11-06 23:42
 */
public class CASFinishAtomOperation {
    private int i = 0;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final CASFinishAtomOperation cas = new CASFinishAtomOperation();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 1000; j++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(thread);
        }
        for (Thread t : ts) {
            t.start();
        }
        for (Thread t:ts){
            t.join();
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());
        System.out.println(System.currentTimeMillis() - start);

    }


    //    非线程安全计数器
    private void count() {
        i++;
    }

    //    CAS操作
    private void safeCount() {
        while (true) {
            int i = atomicInteger.get();
            boolean b = atomicInteger.compareAndSet(i, ++i);
            if (b) {
                break;
            }
        }
    }

}
