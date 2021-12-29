package com.example.demo.StringTest;

import java.util.Arrays;

/**
 * @create 2021-12-29 23:06
 */
public class StringBuilerTest {
    public static void main(String[] args) {
        //append,toString,length,setLength,charAt,deleteCharAt,insert,substring,delete,replace,setCharAt,
        //indexOf,lastIndexOf,reverse,appendCodePoint,getChars,
        Append();
    }
    //append的使用
    public static void Append(){
        StringBuilder builder = new StringBuilder();
        builder.append(111)
                .append(111)
                .append("111")
                .append(Arrays.asList("2222","33333"));
        System.out.println(builder);
        System.out.println(builder.toString());
        System.out.println(builder.length());
        //java.lang.StringBuilder.setLength() 方法将字符序列的长度。该序列被改变为其长度由参数指定一个新的字符序列。
        //如果newLength参数大于或等于当前的长度，足以让空字符('u0000“)附加以使长度成为newLength参数。
        builder.setLength(0);
        System.out.println(builder.length());

    }
}
