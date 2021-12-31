package com.example.demo.StringTest;

/**
 * @create 2021-12-31 1:04
 */
public class StringBufferTest {
    public static void main(String[] args) {
        //toString,<init>,append,length,setLength,charAt,insert,substring,delete,deleteCharAt,replace,indexOf,
        //setCharAt,lastIndexOf,getChars,reverse,ensureCapacity,appendCodePoint,subSequence,capacity,codePointAt,
        //getValue,replace0,reverse0,delete0,deleteCharAt0,insert0,set,append0,appendNull,shareValue,trimToSize,
        //codePointCount,codePointBefore
        //


        //为int时是自定义容器，默认为16
        StringBuffer buffer = new StringBuffer(111);
        StringBuffer bufferone = new StringBuffer("buffer");
        //toString,转成字符串
        buffer.toString();
        buffer.append(111)
                .append("test" + "test")
                .append('1');
        System.out.println(buffer);
        //length
        buffer.length();
        

    }
}
