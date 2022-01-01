package com.example.demo.RandomTest;

import java.util.Random;

/**
 * @create 2022-01-01 13:34
 */
public class RandomTest {
    public static void main(String[] args) {
        //nextInt,<init>,nextDouble,nextLong,nextBytes,nextFloat,nextBoolean,nextGaussian,setSeed,ints,longs,doubles,
        //next,initialScramble
    }
    public static <T> void shuffleArray(T[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            //extInt(int n) 方法用於獲取一個偽隨機，在0(包括)和指定值(不包括)，從此隨機數生成器的序列中取出均勻分布的int值。
            int index = rnd.nextInt(i + 1);
            // Simple swap
            T a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

}
