package com.example.demo.IteratorTest;

import java.util.*;

/**
 * @create 2021-12-29 23:46
 */
public class IteratorTest {
    public static void main(String[] args) {
        //next,hasNext,remove,forEachRemaining


        Collection<String> test = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            test.add(i + "renhq");
        }

        /*
        Iterator的实现为集合的一个内部类，对于不同的集合其内部数据结构不同，但Iterator的效果是类似的，以ArrayList为例，
        其内部数据结构为数组，而ArrayList的Iterator则维护两个指针(指向下标)：
            1、cursor指向下一个元素；
            2、lastRet指向最后一个元素，没有则为-1
        hasNext返回 cursor != size ，size为当前ArrayList维护的数组的大小，即当前ArrayList的长度
        next 则返回数组中第cursor个元素，并且自增
        注意：cursor与lastRet为Iterator维护的，next方法会使cursor自增下标越界，此时除抛出异常外不做其他操作，
            所以使用hasNext进行判断是必要的。
            forEachRemaining本质是while(iterator.hasNext()){iterator.next()}操作
            forEach本质是 for (Type e : collection) {...}操作
         */
        Iterator<String> iterator = test.iterator();

        /*
        对于一个iterator，forEachRemaining遍历输出剩余元素，只能用一次，调用后iterator.hasNext()不再为true了,等同于while循环
        其实现：
        while (hasNext())
            action.accept(next());
         */
        System.out.println("forEachRemaining----------------------");
        iterator.forEachRemaining(String -> System.out.println(String));

        //此时iterator.hasNext()为false
        System.out.println(iterator.hasNext());

        //创建一个新的Iterator
        iterator = test.iterator();

        System.out.println("while---------------------------------");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //forEach内部实现为foreach
        System.out.println("forEach-------------------------------");
        test.forEach(String -> System.out.println(String));

        System.out.println("for-----------------------------------");
        for (String s : test) {
            System.out.println(s);
        }
    }
    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
//    public Map<String, String> toSingleValueMap() {
//        Map<String, String> singleValueMap = new LinkedHashMap<>(this.headers.size());
//        Iterator<HttpField> iterator = this.headers.iterator();
//        iterator.forEachRemaining(field -> {
//            if (!singleValueMap.containsKey(field.getName())) {
//                singleValueMap.put(field.getName(), field.getValue());
//            }
//        });
//        return singleValueMap;
//    }
}
