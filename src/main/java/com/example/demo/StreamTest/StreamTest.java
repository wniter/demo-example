package com.example.demo.StreamTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @create 2021-12-29 21:44
 */

//元素 Stream是一个来自数据源的元素队列，Stream本身并不存储元素。
//数据源（即Stream的来源）包含集合、数组、I/O channel、generator（发生器）等。
//聚合操作 类似SQL中的filter、map、find、match、sorted等操作
//管道运算 Stream在Pipeline中运算后返回Stream对象本身，这样多个操作串联成一个Pipeline，并形成fluent风格的代码。这种方式可以优化操作，如延迟执行(laziness)和短路( short-circuiting)。
//内部迭代 不同于java8以前对集合的遍历方式（外部迭代），Stream API采用访问者模式（Visitor）实现了内部迭代。
//并行运算 Stream API支持串行（stream() ）或并行（parallelStream() ）的两种操作方式。

public class StreamTest {
    //https://www.runoob.com/java/java8-streams.html
    //collect,map,filter,forEach,findFirst,of,anyMatch,flatMap,sorted,toArray,findAny,
    // count,allMatch,concat,reduce,mapToInt,distinct,empty,noneMatch,iterator,limit,
    // mapToLong,peek,max,forEachOrdered,skip,mapToDouble,min,parallel,generate,onClose,
    // spliterator,sequential,builder,close,flatMapToInt,flatMapToDouble,iterate,flatMapToLong,isParallel,unordered

    //eg:统计整数数组中正数的个数
    public static void sumcount() {
        List<Integer> numbers = Arrays.asList(-1, -2, 0, 4, 5);
        long count = 0;
        for (Integer number : numbers) {
            if (number > 0) {
                count++;
            }
        }
        System.out.println("Positive count: " + count);
    }

    public static void sumcount1() {
        List<Integer> numbers = Arrays.asList(-1, -2, 0, 4, 5);
        long count = numbers.parallelStream().filter(i -> i > 0).count();
        System.out.println("Positive count: " + count);
    }
    //Stream的生成
    //    /**
    //     * @return a sequential {@code Stream} over the elements in this collection
    //     * @since 1.8
    //     */
    //    default Stream<E> stream() {
    //        return StreamSupport.stream(spliterator(), false);
    //    }
    //
    //    /**
    //     * @return a possibly parallel {@code Stream} over the elements in this collection
    //     * @since 1.8
    //     */
    //    default Stream<E> parallelStream() {
    //        return StreamSupport.stream(spliterator(), true);
    //    }
    //在集合类的接口（Collection）中，分别用两种方式来生成：
    // 1. 串行流 ： stream()
    // 2. 并行流 ： parallelStream()
    public static void main(String[] args) {
        //forEach()方法的参数为一个Consumer（消费函数，一个函数式接口）对象，forEach()方法用来迭代流中的每一个数据，例如：
        // void forEach(Consumer<? super T> action);
        List<Integer> numbers = Arrays.asList(-1, -2, 0, 4, 5);

        numbers.stream().forEach(n ->  System.out.println("List element: " + n));
        // 集合的顶层接口Iterable中也投forEach方法，可以直接对数组元素进行遍历：
        numbers.forEach(n ->  System.out.println("List element: " + n));
        //map()方法的参数为Function（函数式接口）对象，map()方法将流中的所有元素用Function对象进行运算，生成新的流对象（流的元素类型可能改变）。举例如下：
        //<R> Stream<R> map(Function<? super T, ? extends R> mapper);
        numbers.stream().map( n -> Math.abs(n)).forEach(n ->  System.out.println("Element abs: " + n));
        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
        //flatMap()方法，跟map()方法不同的是，Function函数的返回值类型是Stream<? extends R>类型，而不是R类型，即Function函数返回一个Stream流，
        // 这样flatMap()能够将一个二维的集合映射成一个一维的集合，比map()方法拥有更高的映射深度（此处可能有一点绕，可结合例子理解），作个简单示例如下：
        List<String> str = Arrays.asList("1 2", "3 4", "5 6");
        str.stream().flatMap(item -> Arrays.stream(item.split(" "))).forEach(System.out::println);
        str.stream().map(item -> Arrays.stream(item.split(" "))).forEach(n ->n.forEach(System.out::println));
        //Stream<T> filter(Predicate<? super T> predicate);
        //filter()方法的参数为Predicate（函数式接口）对象，再lambda表达式的讲解中我们提到过这个接口，一般用它进行过滤。正如第二章中示例：
        long count = numbers.parallelStream().filter(i -> i>0).count();
        System.out.println("Positive count: " + count);
        //Optional<T> reduce(BinaryOperator<T> accumulator);
        //reduce()方法参数为BinaryOperator类型的累加器（它接受两个类型相同的参数，返回值类型跟参数类型相同），返回一个Optional对象。
        //实际上，Stream API中的mapToInt()方法返回的IntStream接口有类似的 average()、count()、sum()等方法就是做reduce操作，类似的还有mapToLong()、
        // mapToDouble() 方法。当然，我们也可以用reduce()方法来自定义reduce操作。例如我们用reduce()方法来进行整数数组求和操作：
        Integer total = numbers.stream().reduce((t, n) -> t + n).get();
        System.out.println("Total: " + total);
        //collect()方法的参数为一个java.util.stream.Collector类型对象，可以用java.util.stream.Collectors工具类提供的静态方法来生成，
        // Collectors类实现很多的归约操作，如Collectors.toList()、Collectors.toSet()、Collectors.joining()（joining适用于字符串流）等。看一个简单示例：
        // <R, A> R collect(Collector<? super T, A, R> collector);
        List<Integer> abss = numbers.stream().map( n -> Math.abs(n)).collect(Collectors.toList());
        System.out.println("Abs list: " + abss);
        //    Stream API还有一些其它的方法，比如：
        //　　　　limit()　　　 获取指定数量的流
        //　　　　sorted()　 　对流进行排序
        //　　　　distinct()　　去重
        //　　　　skip()　　　　跳过指定数量的元素
        //　　　　peek()　　　生成一个包含原Stream的所有元素的新Stream，并指定消费函数
        //　　　　count()　　　计算元素数量

    }
}
