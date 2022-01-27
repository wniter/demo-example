package com.example.juc.juc.threadbasicconcept;

/**
 * @create 2022-01-27 8:25
 */
public class ThreadState {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread thread = new MyThread();
        // Returns the state of this thread.
        System.out.println(thread.getState());

        thread.start();
        System.out.println(thread.getState());
        thread.join();
        System.out.println(thread.getState());
    }
}
