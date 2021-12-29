package com.example.demo.ListTest;



import java.util.Arrays;

/**
 * @create 2021-12-29 22:10
 */
public class ArrayListOne {
    public static void main(String[] args) {
        //add,size,get,toArray,addAll,remove,clear,isEmpty,iterator,contains,set,indexOf,clone,subList,
        //stream,ensureCapacity,trimToSize,removeAll,toString,equals,listIterator,forEach,hashCode,sort,retainAll,
        //containsAll,lastIndexOf,removeRange,removeIf,parallelStream,replaceAll,

    }

    //set()将此列表中指定位置的元素替换为指定元素。
    public static void Set() {
        java.util.ArrayList<String> list = new java.util.ArrayList<String>(Arrays.asList("cat","cow","dog"));
        list.add("fish");
        int size = list.size();
        list.set(size -1 ,"horse");
        String removed = list.remove(1); // removed = "cow"
        String second = list.get(1); // second = "dog"
    }
}
