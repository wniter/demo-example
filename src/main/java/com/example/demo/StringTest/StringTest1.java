package com.example.demo.StringTest;

import java.util.Arrays;
import java.util.List;

/**
 * @create 2021-12-29 20:27
 */
public class StringTest1 {
    public static void main(String[] args) {
        //boolean contains(CharSequence s)
        // 如果这个字符串包含s，如包含s此方法返回true,否则返回false。
        String str1 = "tutorials point", str2 = "http://";
        CharSequence cs1 = "int";
        // string contains the specified sequence of char values
        boolean retval = str1.contains(cs1);
        System.out.println("Method returns : " + retval);
        // string does not contain the specified sequence of char value
        retval = str2.contains("_");
        System.out.println("Methods returns: " + retval);
        //getBytes(String charsetName)
        //对字符串按照 charsetName 进行编码（unicode→charsetName），返回编码后的字节。
        //getBytes() 表示按照系统默认编码方式进行。
        //
        //String(byte bytes[], Charset charset)
        //对字节按照 charset 进行解码（charset→unicode），返回解码后的字符串。
        //String(byte bytes[]) 表示按照系统默认编码方式进行
        //String s = "浣犲ソ"; //这是"你好"的gbk编码的字符串
        //String ss = new String(s.getBytes("GBK"), "UTF-8");

        //boolean equalsIgnoreCase(String anotherString)
        //equalsIgnoreCase() 不会判断大小写区别

        //replace() 方法通过用 newChar 字符替换字符串中出现的所有 searchChar 字符，并返回替换后的新字符串。
        String Str = new String("Runoob");
        System.out.print("返回值 :");
        System.out.println(Str.replace('o', 'T'));
        System.out.print("返回值 :");
        System.out.println(Str.replace('u', 'D'));
        //isEmpty,charAt,hashCode toString()
        System.out.println(Str.hashCode());

        //compareTo(String anotherString)
        //此方法如果该参数字符串等于此字符串返回值0，如果该字符串是按字典顺序比字符串参数少，返回值小于0，如果这个字符串是按字典顺序比字符串参数大则返回一个大于0的值。
        //Java String Join（）
        // 此方法的第一个参数指定用于连接多个字符串的分隔符。
        // 注意，如果元素为null，则添加"null"。
        String message = String.join("-", "This", "is", "a", "String");
        //message returned is: "This-is-a-String"
        //eg
        List<String> list = Arrays.asList("Steve", "Rick", "Peter", "Abbey");
        String names = String.join(" | ", list);
        System.out.println(names);

    }


}
