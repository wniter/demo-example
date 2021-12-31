package com.example.demo.DoubleTest;

/**
 * @create 2021-12-31 1:04
 */
public class DoubleTest {
    public static void main(String[] args) {
        //parseDouble,valueOf,toString,<init>,isNaN,doubleValue,doubleToLongBits,compare,isInfinite,longBitsToDouble,
        //intValue,doubleToRawLongBits,equals,compareTo,longValue,hashCode,floatValue,isFinite,shortValue,byteValue,

        Double aDouble = new Double(1.1111);
//        Double b  = new Double("aaaaa"); java.lang.NumberFormatException
        Double c = new Double("1.11111");
        //  public Double(String s) throws NumberFormatException {
        //        value = parseDouble(s);
        //    }
        //parseDouble,将String类转化成double类型
//        Double.parseDouble(c);  // is error
        System.out.println(c);
        System.out.println(c.intValue());
    }

    private static boolean containsNaN(double... dataset) {
        for (double value : dataset) {
            if (Double.isNaN(value)) {
                return true;
            }
        }
        return false;
    }
}
