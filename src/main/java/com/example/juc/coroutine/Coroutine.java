package com.example.juc.coroutine;



import kilim.Pausable;
import kilim.Task;
/**
 * @create 2022-01-27 6:44
 */
//Coroutine-demo协同程序
public class Coroutine {
    public static void main(String[] args) {
        Task task  = new Task() {
            @Override
            public  void execute() throws Pausable {
                System.out.println("hello");
                yield();
                System.out.println("hello -1");
                yield();
                System.out.println("finish");
            }
        };
        task.run();
        System.out.println("world");
        task.run();
        System.out.println("world-1");
        task.run();

    }
}
