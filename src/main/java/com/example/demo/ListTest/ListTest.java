package com.example.demo.ListTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @create 2021-12-29 21:08
 */
public class ListTest {
    public static void main(String[] args) {
        //add,size,get,isEmpty,addAll,toArray,contains,remove,iterator,clear,stream,forEach,set,indexOf,
        //list.toArray()转换为数组对象
        //contains()测试此列表是否包含指定的对象。
        //eg
//        Collection<Integer> l = new ArrayList<Integer>();
//        for (int i = 0; i < 10; ++i) {
//            l.add(4);
//            l.add(5);
//            l.add(6);
//        }
//        for (int i: l){
//            if (i == 5){
//                l.remove(i);
//            }
//        }
//        System.out.println(l);
        //这里我使用的是任意的Collection，不一定是ArrayList，所以你不能依赖get。
        //result:Exception in thread "main" java.util.ConcurrentModificationException
        List<String> list = new ArrayList<>();
// This is a clever way to create the iterator and call iterator.hasNext() like
// you would do in a while-loop. It would be the same as doing:
//     Iterator<String> iterator = list.iterator();
//     while (iterator.hasNext()) {
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String string = iterator.next();
            if (string.isEmpty()) {
                // Remove the current element from the iterator and the list.
                iterator.remove();
            }
        }
        //eg
//        @Override
//        public String getPath() {
//            StringBuilder pathBuilder = new StringBuilder();
//            pathBuilder.append(PATH_DELIMITER);
//            for (Iterator<string> iterator = this.pathSegments.iterator(); iterator.hasNext(); ) {
//                String pathSegment = iterator.next();
//                pathBuilder.append(pathSegment);
//                if (iterator.hasNext()) {
//                    pathBuilder.append(PATH_DELIMITER);
//                }
//            }
//            return pathBuilder.toString();
//        }
        //stream
//        stream() − 为集合创建串行流。
//parallelStream() − 为集合创建并行流。
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        //map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
        List<Integer> number = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
        List<Integer> squaresList = number.stream().map( i -> i*i).distinct().collect(Collectors.toList());

        //forEach() 方法用于遍历动态数组中每一个元素并执行特定操作。
        // 创建一个数组
        ArrayList<Integer> numbers = new ArrayList<>();
        // 往数组中添加元素
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        System.out.println("ArrayList: " + numbers);
        // 所有元素乘以 10
        System.out.print("更新 ArrayList: ");
        // 将 lambda 表达式传递给 forEach
        numbers.forEach((e) -> {
            e = e * 10;
            System.out.print(e + " ");
        });
        //equals,hashCode,removeAll,listIterator,sort,containsAll,lastIndexOf,retainAll,removeIf,
    }
}
