package com.example.demo.StringTest;

/**
 * @create 2021-12-28 21:50
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "test demo";
        String st = "test demo";
        System.out.println((str == st));
        System.out.println(str.equals(st));
        System.out.println(str.length());
        // Initializes a newly created
        String string = new String("test demo");
        System.out.println(string);
        //返回string类型1到5的字符串，这是重新new的一个字符串
        System.out.println(str.substring(1, 5));
        str.isEmpty();

        //测试此字符串是否以指定的前缀开头
        boolean retval = str.startsWith(st);
        System.out.println(String.format("测试此字符串是否以指定的前缀开头 %s", retval));
        //eg
        String str1 = "www.tutorialspoint.com";
        System.out.println(str1);
        // the start string to be checked
        String startstr1 = "www";
        String startstr2 = "http://";
        // checks that string starts with given substring
        boolean retval1 = str1.startsWith(startstr1);
        boolean retval2 = str1.startsWith(startstr2);
        // prints true if the string starts with given substring
        System.out.println("starts with " + startstr1 + " ? " + retval1);
        System.out.println("starts with " + startstr2 + " ? " + retval2);

        //将该字符串围绕给定的匹配进行拆分
        
        String s = String.format("111=%s", str);
        System.out.println(s);

    }
}
