package com.example.demo.MathTest;

/**
 * @create 2021-12-31 0:50
 */
public class MathTest {
    public static void main(String[] args) {
        //min,max,abs,round,pow,sqrt,ceil,floor,random,sin,cos,log,exp,toRadians,atan2,log10,acos,tan,
        //toDegrees,atan,signum,asin,toIntExact,rint,hypot,sinh,tanh,cosh,log1p,addExact,cbrt,nextUp,floorDiv,
        //ulp,multiplyExact,copySign,getExponent,floorMod,IEEEremainder,nextAfter,expm1,subtractExact,scalb,nextDown,

        int[] arg = {1, 2, 3, 45, 6243, 123, 12};
        int min = 0;
        int max = 0;
        for (int i = 0; i < arg.length; i++) {
            Math.min(min,arg[i]);
            Math.max(max,arg[i]);
        }
        double value = 5.5;
        Math.floor(value); //  5
        Math.ceil(value)  ;//  6
        Math.round(value) ;//  6


    }
    //abs
    static public boolean isZero (float value, float tolerance) {
        return Math.abs(value) <= tolerance;
    }
}
