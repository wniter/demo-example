package com.example.demo.ListsTest;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @create 2021-12-31 22:08
 */
//   <dependency>
//            <groupId>com.google.code.google-collections</groupId>
//            <artifactId>google-collect</artifactId>
//            <version>snapshot-20080530</version>
//        </dependency>
public class ListsTest {
    public static void main(String[] args) {
        //newArrayList,transform,newLinkedList,newArrayListWithCapacity,reverse,newArrayListWithExpectedSize,partition,
        //asList,newCopyOnWriteArrayList,charactersOf,cartesianProduct,computeArrayListCapacity,addAllImpl,equalsImpl,
        //hashCodeImpl,indexOfImpl,lastIndexOfImpl,subListImpl,listIteratorImpl,cast,lastIndexOfRandomAccess,indexOfRandomAccess

    }

    public static void createArrayList() {
        //创建 java.util.ArrayList
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        System.out.println(list);
    }

    public static void transformArrayList() {
        //将其他 Collection 类型的集合转换成 ArrayList
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        List<String> list = Lists.newArrayList(set);
        System.out.println(list);
    }
    //使用 reverse 方法翻转 List delete
//    public static void reverseArayList() {
//        List<String> originList = Lists.newArrayList("1", "2");
//        List<String> reversedList = Lists.reverse(originList);
//
//        System.out.println("原List: " + originList);
//        System.out.println("翻转后:  " + reversedList);
//    }
//    //使用 partition 方法将一个List拆分为多个List delete
//    public static void partitionArrayList(){
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        // 按大小 2 拆分
//        List<List<Integer>> listPartitionList = Lists.partition(list, 2);
//
//        System.out.println("原 List:");
//        System.out.println(list);
//
//        System.out.println("拆分后:");
//        for (List<Integer> partition: listPartitionList) {
//            System.out.println(partition);
//        }
//    }

}
