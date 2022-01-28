package com.example.juc.jucone.TestOne.notifyandwait;

/**
 * @create 2021-11-09 23:27
 */
public class NotifyAndWait {

    //void wait(）： 导致当前线程 直处千等待， 直到另外的线程调用这个对象的 notify(）或者 noti于yAll(）方法， 又或者 直等待其他的
    //线程中断当前等待的线程。
//    void wait (long timeout)
    //void wait(long timeout, int nanos)：
    //•	void notify(）： 唤醒正在等待该对象监听器的单条线程。 如果有几一
    //条线程在该对象上等待， 其中某 条会被挑选出来唤醒， 这种选择是随意的且取决于具体实现。 除非当前线程释放了该对象上的锁，被唤 一
    //醒的线程仍不能执行。 被唤醒的线程跟平常 样， 同其他可能活跃的一
    //线程 起竞争在该对象上进行同步。 举个例子，被唤醒的线程在接下来锁住对象这件事上， 既没有优势也没有劣势。\
//    void notifyAll(）：

    //生产者与消费者
}
