package com.example.demo.TimeUnitTest;

import java.util.concurrent.TimeUnit;

/**
 * @create 2021-12-31 22:07
 */
public class TimeUnitTest {
//    public long toMillis(long d)    //转化成毫秒
//    public long toSeconds(long d)  //转化成秒
//    public long toMinutes(long d)  //转化成分钟
//    public long toHours(long d)    //转化成小时
//    public long toDays(long d)     //转化天
    public static void main(String[] args) {
        //toMillis,convert,toNanos,sleep,toSeconds,toMinutes,toMicros,toDays,valueOf,toHours,toString,name,timedWait,
        //hashCode,timedJoin,values,equals,ordinal,compareTo,excessNanos,getDeclaringClass


        //convert 1 day to 24 hour
        System.out.println(TimeUnit.DAYS.toHours(1));
        //convert 1 hour to 60*60 second.
        System.out.println(TimeUnit.HOURS.toSeconds(1));
        //convert 3 days to 72 hours.
        System.out.println(TimeUnit.HOURS.convert(3, TimeUnit.DAYS));

        Thread t = new Thread(new Runnable() {
            private int count = 0;

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        // Thread.sleep(500); //sleep 单位是毫秒
                        TimeUnit.SECONDS.sleep(1); // 单位可以自定义,more convinent
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    System.out.println(count);
                }
            }
        });
        t.start();
    }
}
