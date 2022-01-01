package com.example.demo.StreamTest;

import java.io.*;

/**
 * @create 2021-12-31 1:07
 */
public class ByteArrayOutputStreamTest {
    public static void main(String[] args) throws Exception{
        //<init>,toByteArray,write,toString,close,size,reset,flush,writeTo,expand
        //	public int read()
        //从此输入流中读取下一个数据字节。
        //2	public int read(byte[] r, int off, int len)
        //将最多 len 个数据字节从此输入流读入字节数组。
        //3	public int available()
        //返回可不发生阻塞地从此输入流读取的字节数。
        //4	public void mark(int read)
        //设置流中的当前标记位置。
        //5	public long skip(long n)
        //从此输入流中跳过 n 个输入字节
        ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12);

        while( bOutput.size()!= 10 ) {
            // 获取用户输入值
            bOutput.write(System.in.read());
        }

        byte b [] = bOutput.toByteArray();
        System.out.println("Print the content");
        for(int x= 0 ; x < b.length; x++) {
            // 打印字符
            System.out.print((char)b[x]  + "   ");
        }
        System.out.println("   ");

        int c;

        ByteArrayInputStream bInput = new ByteArrayInputStream(b);

        System.out.println("Converting characters to Upper case " );
        for(int y = 0 ; y < 1; y++ ) {
            while(( c= bInput.read())!= -1) {
                System.out.println(Character.toUpperCase((char)c));
            }
            bInput.reset();
        }
    }
}
