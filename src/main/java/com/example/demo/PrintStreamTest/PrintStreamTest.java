package com.example.demo.PrintStreamTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @create 2021-12-31 0:39
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        //println,print,<init>,printf,flush,close

        //三个输出
        System.out.println();
        System.out.print("test");
        System.out.printf("test");

        // Put things back
        System.out.flush();
    }

    //Closes the stream.
    private String stacktrace(Exception e) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os, true);
        e.printStackTrace(ps);
        ps.close();
        return os.toString();
    }

    //研究一下
    public static void Test() {
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        System.out.println("Foofoofoo!");
        // Put things back
        System.out.flush();
        System.setOut(old);
        // Show what happened
        System.out.println("Here: " + baos.toString());
    }
}
