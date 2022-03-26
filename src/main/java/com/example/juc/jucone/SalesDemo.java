package com.example.juc.jucone;

import com.example.coccurrentdemo.common.Print;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.Super;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * “逻辑和数据更好的分离”演示实例
 * 实现 Runnable 接口的方式创建线程执行目标类，更加适合多个线程的代码逻辑，去共享计算
 * 和处理同一个资源的场景。这一点优势不是太好理解，接下来通过具体例子说明一下。
 */
public class SalesDemo {

    private static Object getCurThreadName() {
        return Thread.currentThread().getName();
    }
    //商品的数量
    public static final int MAX_AMOUNT = 5;

    private static void sleepMilliSeconds(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //商店商品类（销售线程类），一个商品一个销售线程，每条线程异步销售 4 次
    static class StoresGoods extends Thread {
        private int goodsAmount = MAX_AMOUNT;

        StoresGoods(String name) {
            super(name);
        }

        public void run() {
            {
                for (int i = 0; i <= MAX_AMOUNT; i++) {
                    if (this.goodsAmount > 0) {
                        Print.cfo(getCurThreadName() + " 卖出一件，还剩："
                                + (--goodsAmount));
                        sleepMilliSeconds(10);
                    }
                }
                Print.cfo(getCurThreadName() + " 运行结束.");
            }
        }


    }

    //商场商品类型（target 销售线程的目标类），一个商品最多销售 4 次，可以多人销售
    static class MallGoods implements Runnable {
        //多人销售可能导致数据出错，使用原子数据类型保障数据安全
        private AtomicInteger goodsAmount = new AtomicInteger(MAX_AMOUNT);

        public void run() {
            for (int i = 0; i <= MAX_AMOUNT; i++) {
                if (this.goodsAmount.get() > 0) {
                    Print.cfo(getCurThreadName() + " 卖出一件，还剩："
                            + (goodsAmount.decrementAndGet()));
                    sleepMilliSeconds(10);
                }
            }
            Print.cfo(getCurThreadName() + " 运行结束.");
        }

    }

    public static void main(String args[]) throws InterruptedException {
        Print.hint("商店版本的销售");
        for (int i = 1; i <= 2; i++) {
            Thread thread = null;
            thread = new SalesDemo.StoresGoods("店员-" + i);
            thread.start();
        }
        Thread.sleep(1000);

    }

}

