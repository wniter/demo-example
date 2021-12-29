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

        //使用指定的格式字符串和返回格式化字符串
        System.out.println(String.format("111=%s", str));
        //将该字符串围绕给定的匹配进行拆分 split
        //eg
        String splitstr1 = "www.wwww.wwww";
        String[] splitstr2 = splitstr1.split(".");
        System.out.println(splitstr2);
        //trim()去除字符串中首尾空格
        String trim1 = "   1111   ";
        System.out.println(trim1.trim());
        //valueof(T a) 将T类型转化成字符串
        //eg
        int int1 = 111;
        System.out.println(String.valueOf(int1));
        //indexOf(String str, int fromIndex)从fromIndex搜索str，返回第一次出现str的索引
        //lastIndexOf(int ch, int fromIndex)返回此字符串中最后一次出现的指定字符的索引，从指定的索引开始向后搜索。
        String index_of = "Collections of tutorials at tutorials point";
        System.out.println("index = " + index_of.indexOf("tutorials", 10));
        System.out.println("index = " + index_of.indexOf("admin"));

        //endsWith(String suffix) 返回是否这个字符串的后缀为Suffix
        String endsWith1 = "www.gitbook.net";
        // the end string to be checked
        String endstr1 = ".com";
        String endstr2 = ".org";
        // checks that string str ends with given substring
        boolean endsWith2 = endsWith1.endsWith(endstr1);
        boolean endsWith3 = endsWith1.endsWith(endstr2);
        // prints true if the string ends with given substring
        System.out.println("ends with " + endstr1 + " ? " + endsWith2);
        System.out.println("ends with " + endstr2 + " ? " + endsWith3);

        //toLowerCase()把字符串转化成小写
        str.toLowerCase();


    }
}
