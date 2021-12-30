package com.example.demo.IntegerTest;

/**
 * @create 2021-12-29 23:24
 */
public class IntegerTest {
    public static void main(String[] args) {
        //parseInt,toString,valueOf,intValue,<init>,toHexString,equals,compareTo,hashCode,compare,longValue,decode,
        //numberOfLeadingZeros,getInteger,doubleValue,toBinaryString,byteValue,bitCount,shortValue,

        Integer integer = new Integer("1");
        Integer integer1 = new Integer(111);
        int parseInt = Integer.parseInt(String.valueOf(integer));
        //返回一个int类型
        integer.intValue();


    }
    //compareTo(Integer anotherInteger)
    //此方法返回0值，如果該整數等於參數的整數，返回小於0值，
    // 如果該整數數值小於參數整數；返回一個大於0的值，如果該整數數值小於參數整數。
    public static void  CompareTo(){
        // compares two Integer objects numerically
        Integer obj1 = new Integer("25");
        Integer obj2 = new Integer("10");
        int retval =  obj1.compareTo(obj2);

        if(retval > 0) {
            System.out.println("obj1 is greater than obj2");
        }
        else if(retval < 0) {
            System.out.println("obj1 is less than obj2");
        }
        else {
            System.out.println("obj1 is equal to obj2");
        }

    }
}
