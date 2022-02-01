package com.example.juc.juctwo;

/**
 * @create 2022-02-01 18:29
 */
public class Demo {

    int a=0;
    volatile  boolean flag=false;

    public void writer(){ //线程A
        a=1;             //1
        flag=true;       //2

    }
    public void reader(){

        if(flag){  //3
            int x=a; //4
        }
    }
}
