package com.example.demo.ExecutorsTest;

import okhttp3.HttpUrl;
import okhttp3.internal.NamedRunnable;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @create 2021-12-31 21:53
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        //newFixedThreadPool,newSingleThreadExecutor,newCachedThreadPool,
        // newSingleThreadScheduledExecutor,newScheduledThreadPool,defaultThreadFactory,callable,
        // unconfigurableScheduledExecutorService,unconfigurableExecutorService,newWorkStealingPool,privilegedThreadFactory

    }

    private void parallelDrainQueue(int threadCount) {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executor.execute(new NamedRunnable("Crawler %s", i) {
                @Override
                protected void execute() {
                    try {
                        drainQueue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executor.shutdown();
    }

    private void drainQueue() throws Exception {
        Thread currentThread = Thread.currentThread();
        String originalName = currentThread.getName();
        currentThread.setName("Crawler ");


    }
}
