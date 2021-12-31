package com.example.demo.BooleanTest;

/**
 * @create 2021-12-31 0:53
 */
public class BooleanTest {
    private static final Boolean FALSE = false;
    private static final Boolean TRUE = true;

    public static void main(String[] args) {
        //valueOf,parseBoolean,booleanValue,toString,equals,<init>,getBoolean,hashCode,compareTo,compare,
        Boolean a = new Boolean(true);
        Boolean b = new Boolean("false");
        //返回boolean类型
        a.booleanValue();
        //把基本类型转化为对象类型的方法；返回对象的值；获取布尔型对象的值（返回值为布尔型）
        System.out.println(Boolean.valueOf(b));
        //toString是转化成string类型
        a.toString();

    }
    //parseBoolean
    public static boolean parseBoolean(String s) {
        return ((s != null) && s.equalsIgnoreCase("true"));
    }

    public static Boolean valueOf(String s) {
        return parseBoolean(s) ? TRUE : FALSE;
    }

}
