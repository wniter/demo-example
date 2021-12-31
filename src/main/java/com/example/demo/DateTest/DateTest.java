package com.example.demo.DateTest;

import com.nimbusds.jwt.util.DateUtils;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * @create 2021-12-31 0:57
 */
public class DateTest {
    public static void main(String[] args) {
        //<init>,getTime,toString,before,equals,after,compareTo,hashCode,setTime,from,toInstant,clone,getYear,
        //getMonth,getDate,getHours,getMinutes,getSeconds,getDay,setMinutes,parse,setYear,setHours,toLocaleString,
        //setSeconds,toGMTString,getTimezoneOffset,setMonth,setDate,UTC,parseError,zone,appendTwoDigits,getFullYear,
        new Date().getTime();


    }
    private static long parseIso8601(String value) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(value).getTime();
        } catch (ParseException ignored) {
            return 0;
        }
    }
    private static void outPrintln(PrintStream out, String msg) {
        out.println(Calendar.getInstance().getTime().toString()  + " " + msg);
    }
    public boolean isExpired() {
        Date expiration = new Date();
        return expiration != null && expiration.before(new Date());
    }
    private static boolean checkParseCompressedIso8601Date() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        sdf.setTimeZone(new SimpleTimeZone(0, "GMT"));
        String formatted = sdf.format(date);
        Date expected = sdf.parse(formatted);
        Date actual = new Date();
        return expected.equals(actual);
    }
    
    public boolean isDateExpired(String input, Date expiration) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        Date date = dateFormat.parse(input);
        //测试此日期是否在指定日期之后。
        return date.after(expiration);
    }
}
