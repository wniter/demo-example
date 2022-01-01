package com.example.demo.ThreadTest;

import lombok.extern.java.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @create 2021-12-31 21:53
 */
public class ThreadLocalTest {

    //ThreadLocal() -->创建一个线程本地变量
    //
    //get() -->返回线程本地变量的当前线程副本中的值,如果第一次调用get()方法则返回的值是null
    //
    //protected T initialValue() --> 返回此线程本地变量的当前线程的初始值。最多在每次访问线程来获得每个线程局部变量时调用此方法一次，即线程第一次使用 get() 方法访问变量的时候。如果线程先于 get 方法调用 set(T) 方法，则不会在线程中再调用 initialValue 方法
    //
    //set(T value) -->将线程本地变量的当前线程副本中的值设置为指定值.许多应用程序不需要此方法,它们只依赖于initialValue()方法来设置线程局部变量的值.
    //
    //void remove() --> 移除此线程局部变量的值，这可能有助于减少线程局部变量的存储需求。如果再次访问此线程局部变量，那么在默认情况下它将拥有其 initialValue。
    //
    //在程序中一般都重写initialValue方法，以给定一个特定的初始值。

    public static ThreadLocal t1 = new ThreadLocal();
    public static void main(String[] args) {
        //get,set,remove,<init>,withInitial,initialValue,initializeValues,values
        if(t1.get() == null) {
            System.out.println("从未放过值");
            t1.set("我的值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
//public class HibernateUtil {
//    private static Log log = LogFactory.getLog(HibernateUtil.class);
//    private static final SessionFactory sessionFactory;     //定义SessionFactory
//
//    static {
//        try {
//            // 通过默认配置文件hibernate.cfg.xml创建SessionFactory
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            log.error("初始化SessionFactory失败！", ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    //创建线程局部变量session，用来保存Hibernate的Session
//    public static final ThreadLocal session = new ThreadLocal();
//
//    /**
//     * 获取当前线程中的Session
//     * @return Session
//     * @throws HibernateException
//     */
//    public static Session currentSession() throws HibernateException {
//        Session s = (Session) session.get();
//        // 如果Session还没有打开，则新开一个Session
//        if (s == null) {
//            s = sessionFactory.openSession();
//            session.set(s);         //将新开的Session保存到线程局部变量中
//        }
//        return s;
//    }
//
//    public static void closeSession() throws HibernateException {
//        //获取线程局部变量，并强制转换为Session类型
//        Session s = (Session) session.get();
//        session.set(null);
//        if (s != null)
//            s.close();
//    }
//}
