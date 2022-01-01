package com.example.demo.AtomicIntegerTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @create 2021-12-31 22:02
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        //incrementAndGet,get,<init>,getAndIncrement,set,decrementAndGet,addAndGet,compareAndSet,intValue,getAndSet,
        //getAndDecrement,getAndAdd,toString,lazySet,longValue,doubleValue,updateAndGet,getAndUpdate,accumulateAndGet,
        //weakCompareAndSet,floatValue,getAndAccumulate,byteValue,shortValue
        //public final int get() //获取当前的值
        //public final int getAndSet(int newValue)//获取当前的值，并设置新的值
        //public final int getAndIncrement()//获取当前的值，并自增
        //public final int getAndDecrement() //获取当前的值，并自减
        //public final int getAndAdd(int delta) //获取当前的值，并加上预期的值

    }

}
//普通线程同步
class Test2 {
    private volatile int count = 0;

    public synchronized void increment() {
        count++; //若要线程安全执行执行count++，需要加锁
    }

    public int getCount() {
        return count;
    }
}
class Test3 {
    private AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();
    }
    //使用AtomicInteger之后，不需要加锁，也可以实现线程安全。
    public int getCount() {
        return count.get();
    }
}