package com.example.demo.SystemTest;

import java.io.Console;
import java.util.Properties;

/**
 * @create 2021-12-30 23:24
 */
public class SystemTest {

    private static Properties pros;
    static {
        setValue();
    }
    public static void main(String[] args) {
        //currentTimeMillis,getProperty,arraycopy,exit,setProperty,nanoTime,getenv,getProperties,identityHashCode,
        //getSecurityManager,gc,lineSeparator,clearProperty,setOut,setErr,loadLibrary,console,load,setSecurityManager,
        //currentTimeMillis,运行时间
        long time = System.currentTimeMillis();

        //getProperty and setProperty
        System.out.println(System.getProperty("key"));
        System.out.println(System.getProperty("String"));

        //System.getProperties()可以确定当前的系统属性,返回值是一个Properties
        System.getProperties();
        //将系统属性设置为Properties参数
        System.setProperties(pros);


    }
    //getProperty and setProperty
   public static void setValue(){
        System.setProperty("key","value");
        System.setProperty("String","String");
   }
   //System.arraycopy(int[] arr, int star,int[] arr2, int start2, length);
//    5个参数，
//    第一个参数是要被复制的数组
//            第二个参数是被复制的数字开始复制的下标
//    第三个参数是目标数组，也就是要把数据放进来的数组
//            第四个参数是从目标数据第几个下标开始放入数据
//    第五个参数表示从被复制的数组中拿几个数值放到目标数组中
//    比如：
//    数组1：int[] arr = { 1, 2, 3, 4, 5 };
//    数组2：int[] arr2 = { 5, 6,7, 8, 9 };
//    运行：System.arraycopy(arr, 1, arr2, 0, 3);
//    得到：
//    int[] arr2 = { 2, 3, 4, 8, 9 };
   public static String[] concat(String[] array, String value) {
       String[] result = new String[array.length + 1];
       System.arraycopy(array, 0, result, 0, array.length);
       result[result.length - 1] = value;
       return result;
   }

   //System.exit(-1)、System.exit(0)、System.exit(1)区别
    //System.exit(0) ： 将整个虚拟机里的内容都关掉，内存都释放掉！正常退出程序。
    //System.exit(1) ： 非正常退出程序
    //System.exit(-1) ：非正常退出程序

    //返回当前运行的Java虚拟机的值
    public static long systemNanoTime() {
        return System.nanoTime();
    }
    //获取系统安全接口
    protected boolean isSecurityManagerPresent() {
        return (System.getSecurityManager() != null);
    }

    //gc()运行垃圾收集器。
    public void accept(byte[] v) throws Exception {
        System.out.println("Bounded Replay Leak check: Wait before GC 2");
        Thread.sleep(1000);
        System.out.println("Bounded Replay Leak check:  GC 2");
        System.gc();
        Thread.sleep(500);

    }
    //加载由filename参数指定的本机库。 文件名参数必须是绝对路径名。
    public static void loadLibrary(String libName, boolean absolute) {
        if (absolute) {
            System.load(libName);
        } else {
            System.loadLibrary(libName);
        }
    }
    //
    public static void InitConsole() {
        //https://www.itranslater.com/qa/details/2127177329045668864
        Console console = System.console();
    }
}
