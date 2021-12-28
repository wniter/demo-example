package com.example.demo;

import org.junit.jupiter.api.Test;

/**
 * @create 2021-12-28 21:05
 */
public class StringTest {

    @Test
    private void StringTest() throws Exception {
        String str = "test demo";
        String st = "test demo";
        System.out.println((str == st));
        System.out.println(str.equals(st));
    }


}
