package com.example.demo.StreamTest;

import com.example.demo.config.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @create 2022-01-01 21:19
 */
//java.util.stream.Collectors
public class CollectorsTest {
    public static void main(String[] args) {
        //toList,toSet,joining,toMap,groupingBy,toCollection,collectingAndThen,counting,mapping,
        // partitioningBy,reducing,toConcurrentMap,maxBy,summingInt,summingLong,minBy,groupingByConcurrent,
        // summingDouble,summarizingLong,averagingInt,averagingDouble,summarizingInt,summarizingDouble,
        // averagingLong,toUnmodifiableList,toUnmodifiableMap

        //Java 8 流的新类 java.util.stream.Collectors 实现了 java.util.stream.Collector 接口，
        // 同时又提供了大量的方法对流 ( stream ) 的元素执行 map and reduce 操作，或者统计操作。
//Java 所有集合的 stream().collect() 可以接受一个收集器实例作为其参数并返回该收集器的计算结果
//
//例如下面的代码，collect() 方法会把所有的元素收集起来然后传递给 Collectors.averagingDouble(d->d*2) 收集器，对每个元素执行 *2 操作后计算平均值
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Double result = list.stream().collect(Collectors.averagingDouble(d -> d * 2));
        System.out.println(result);
        //Collectors.averagingInt() 方法和 Collectors.averagingDouble() 一样，不同的是它把流中的所有元素看成是 int 类型，并返回一个浮点类型的平均值
        list.stream().collect(Collectors.averagingInt(v -> v * 2));
        //Collectors.collectingAndThen() 函数应该最像 map and reduce 了，它可接受两个参数，第一个参数用于 reduce 操作，而第二参数用于 map 操作。
        //也就是，先把流中的所有元素传递给第二个参数，然后把生成的集合传递给第一个参数来处理。
        //例如下面的代码，先把 [1,2,3,4] 这个集合传递给 s-> s*s lambda 表达式，计算得出结果为 [1,4,9,16] ，然后再把 [1,4,9,16] 传递给 v->v*2 表达式，计算得出 [2,8,18,32] ，然后传递给 Collectors.averagingLong() 计算得到结果为 25.0
        list.stream().collect(Collectors.collectingAndThen(Collectors.averagingLong(v -> v * 2), s -> s * s));
        //Collectors.counting() 用于统计流中元素的个数。
        list.stream().collect(Collectors.counting());
        //Collectors.joining() 方法用某个指定的拼接字符串把所有元素拼接成一个字符串，并添加可选的前缀和后缀
        List<String> l = Arrays.asList("A", "B", "C", "D");
        l.stream().collect(Collectors.joining(",", "(", ")"));
//        Collectors.maxBy() 和 Collectors.minBy() 两个方法分别用于计算流中所有元素的最大值和最小值。
        //Get Max
        list.stream().collect(Collectors.maxBy(new CollectorsTest().new IntegerComp()))
                .ifPresent(i -> System.out.println(i));
        //Get Min
        list.stream().collect(Collectors.minBy(new CollectorsTest().new IntegerComp()))
                .ifPresent(i -> System.out.println(i));
        //Collectors.summingInt() 方法将流中的所有元素视为 int 类型，并计算所有元素的总和 ( sum )
        list.stream().collect(Collectors.summingInt(i -> i));
        //Collectors.toList() 将流中的所有元素导出到一个列表 ( List ) 中
        //Creating a stream from an array is safe
        // of()
        List<String> a = Stream.of("AA", "BB", "CC").collect(Collectors.toList());
        a.forEach(i -> System.out.println(i));
        //Collectors.toSet() 把流中的所有元素导出到一个集合 ( Set ) 中，并排除重复的元素 ( Set 的特性 )
        Set<String> set = Stream.of("AA","AA","BB").collect(Collectors.toSet());
        set.forEach(s->System.out.println(s));
        //Collectors.toMap() 将流中的所有元素导出到一个哈希表 ( Map ) 中。
        // 该方法接受两个参数，第一个参数用于生成键 ( key ) ，第二个参数用于生成值 ( value )。两个参数都是 Lambda 表达式。
        Map<String,String> map = Stream.of("AA","BB","CC").collect(Collectors.toMap(k->k, v->v+v));
        map.forEach((k,v)->System.out.println("key:"+k +"  value:"+v));
        //Collectors.mapping() 一般用于多重 map and reduce 中。 Java 文档中描述的原型如下
        //mapping(Function<? super T,? extends U> mapper, Collector<? super U,A,R> downstream)
        //第一个参数用于 map ，第二个参数用于 reduce
        List<Person> lista = Person.getList();
        Map<Integer, String> nameByAge
                = lista.stream().collect(Collectors.groupingBy(Person::getAge,
                Collectors.mapping(Person::getName, Collectors.joining(","))));
        nameByAge.forEach((k,v)->System.out.println("Age:"+k +"  Persons: "+v));

    }

    class IntegerComp implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            if (i1 >= i2) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
