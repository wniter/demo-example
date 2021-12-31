package com.example.demo.LongTest;

/**
 * @create 2021-12-31 0:51
 */
public class LongTest {
    public static void main(String[] args) {
        //parseLong,toString,valueOf,longValue,<init>,intValue,equals,hashCode,toHexString,compareTo,compare
        //doubleValue,decode,numberOfLeadingZeros,numberOfTrailingZeros,bitCount,signum,reverseBytes,toBinaryString,
        //shortValue,rotateLeft,getLong,byteValue,floatValue,highestOneBit,reverse,compareUnsigned,max, min, sum,

        Long aLong = new Long(111);
        Long bLong = new Long("111");
        //parseLong将String类型转成Long类型
        String s = "test";
        Long.parseLong(String.valueOf(bLong));
        Long.parseLong(s);
        aLong.compareTo(bLong);
        Long.compare(aLong,bLong);

    }
}
