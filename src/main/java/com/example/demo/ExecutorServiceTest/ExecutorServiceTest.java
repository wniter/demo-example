package com.example.demo.ExecutorServiceTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @create 2021-12-31 22:03
 */
public class ExecutorServiceTest {
    //https://blog.csdn.net/weixin_40304387/article/details/80508236?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0.no_search_link&spm=1001.2101.3001.4242.1&utm_relevant_index=3
    public static void main(String[] args) throws Exception {
        //submit,shutdown,execute,shutdownNow,awaitTermination,isShutdown,isTerminated,invokeAll,invokeAny
        //ExecutorService是Java中对线程池定义的一个接口，它java.util.concurrent包中，在这个接口中定义了和后台任务执行相关的方法：

//        1. newCachedThreadPool 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
//        2. newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
//        3. newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
//        4. newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        executorService.shutdown();
//submit(Runnable)和execute(Runnable)区别是前者可以返回一个Future对象，通过返回的Future对象，我们可以检查提交的任务是否执行完毕，请看下面执行的例子：
        Future future = executorService.submit(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        future.get();  //returns null if the task has finished correctly.


    }
}
