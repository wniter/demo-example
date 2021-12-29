package com.example.demo.MapTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @create 2021-12-29 21:57
 */
public class MapTest {
    public static void main(String[] args) {
        //主要方法：
        //put,get,entrySet,containsKey,keySet,values,remove,size,isEmpty,clear,putAll,forEach,equals,containsValue
        //merge,replace
    }

    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    //hashmap.replace(K key, V oldValue, V newValue)
    public static void rePlace() {
        // 创建一个 HashMap
        HashMap<Integer, String> sites = new HashMap<>();

        // 往 HashMap 添加一些元素
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        System.out.println("sites HashMap: " + sites);

        // 替换key为2的映射
        String value = sites.replace(2, "Wiki");

        System.out.println("Replaced Value: " + value);
        System.out.println("Updated HashMap: " + sites);
    }

    //hashmap.merge(key, value, remappingFunction)
    //key - 键
    //value - 值
    //remappingFunction - 重新映射函数，用于重新计算值
    //如果 key 对应的 value 不存在，则返回该 value 值，如果存在，则返回通过 remappingFunction 重新计算后的值。
    public static void Merge() {
        //创建一个HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往 HashMap 插入映射
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        int returnedValue = prices.merge("Shirt", 100, (oldValue, newValue) -> oldValue + newValue);
        System.out.println("Price of Shirt: " + returnedValue);

        // 输出更新后的 HashMap
        System.out.println("Updated HashMap: " + prices);
    }
}

