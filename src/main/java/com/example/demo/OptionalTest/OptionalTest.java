package com.example.demo.OptionalTest;

import java.util.Optional;

/**
 * @create 2022-01-01 12:24
 */
public class OptionalTest {
    public static void main(String[] args) {
        //容器
        //get,orElse,isPresent,ofNullable,empty,of,map,ifPresent,orElseThrow,orElseGet,filter,flatMap,equals,
        //hashCode,toString,isEmpty,<init>,ifPresentOrElse

        //Optional.of(T t) : 创建一个Optional 实例
        //Optional.empty() : 创建一个空的Optional 实例
        //Optional.ofNullable(T t):若t 不为null,创建Optional 实例,否则创建空实例
        //isPresent() : 判断是否包含值
        //orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
        //orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回s 获取的值
        //map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
        //flatMap(Function mapper):与map 类似，要求返回值必须是Optional

// Optional.of(T t)：封装一个Optional实例，其中值t不能为null，否则有NullPointException
        Optional<Demo> optional1 = Optional.of(new Demo());
        System.out.println(optional1.get());
        // 运行结果：Demo{name='null', age=null, salary=null, status=null}

        // Optional.empty()：封装一个空的Optional对象（封装null）
        Optional<Demo> optional2 = Optional.empty();
        System.out.println(optional2.get());
        // 运行结果：Exception in thread "main" java.util.NoSuchElementException: No value present
        //	        at java.util.Optional.get(Optional.java:135)
        //	        at TestOptional.main(TestOptional.java:16)

        // Optional.ofNullable(T t):非null就和of方法一样，null就和empty()一样
        Optional<Demo> optional3 = Optional.ofNullable(new Demo());
        // isPresent()：判断其中是否包含值
        if (optional3.isPresent()) {
            System.out.println(optional3.get());
        }
        // 运行结果：Demo{name='null', age=null, salary=null, status=null}

        // orElse(T t) : 如果包含值，那返回值；否则返回替代值T
        Optional<Demo> optional4 = Optional.ofNullable(null);
//        Demo demo1 = optional4.orElse(new Demo("里斯", 24, 15000.1, Demo.Status.FREE));
//        System.out.println(demo1);
        // 运行结果：Demo{name='里斯', age=24, salary=15000.1, status=FREE}

        // orElseGet(Supplier s) :如果包含值，那返回值；否则返回s 获取的值
        Demo demo2 = optional4.orElseGet(() -> new Demo());
        System.out.println(demo2);
        // 运行结果：Demo{name='null', age=null, salary=null, status=null}

        // map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
//        Optional<Demo> optional5 = Optional.ofNullable(new Demo("里斯", 24, 15000.1, Demo.Status.FREE));
//        Optional<String> stringOptional1 = optional5.map(x -> x.getName());
//        System.out.println(stringOptional1.get());
        // 运行结果：里斯

        // flatMap(Function mapper):与map 类似，要求返回值必须是Optional
//        Optional<String> stringOptional2 =  optional5.flatMap(x -> Optional.of(x.getName()));
//        System.out.println(stringOptional2.get());
        // 运行结果：里斯
    }

    static class Demo {


    }
//    public long getTotalPartitionsCount(String keyspace, String table, Optional<Long> sessionSplitsPerNode)
//    {
//        if (sessionSplitsPerNode.isPresent()) {
//            return sessionSplitsPerNode.get();
//        }
//        else if (configSplitsPerNode.isPresent()) {
//            return configSplitsPerNode.get();
//        }
//        List<SizeEstimate> estimates = session.getSizeEstimates(keyspace, table);
//        return estimates.stream()
//                .mapToLong(SizeEstimate::getPartitionsCount)
//                .sum();
//    }

//    private static Optional<Domain> getDomain(OptionalInt timestampOrdinalPosition, TupleDomain<LocalFileColumnHandle> predicate)
//    {
//        Optional<Map<LocalFileColumnHandle, Domain>> domains = predicate.getDomains();
//        Domain domain = null;
//        if (domains.isPresent() && timestampOrdinalPosition.isPresent()) {
//            Map<LocalFileColumnHandle, Domain> domainMap = domains.get();
//            Set<Domain> timestampDomain = domainMap.entrySet().stream()
//                    .filter(entry -> entry.getKey().getOrdinalPosition() == timestampOrdinalPosition.getAsInt())
//                    .map(Map.Entry::getValue)
//                    .collect(toSet());
//            if (!timestampDomain.isEmpty()) {
//                domain = Iterables.getOnlyElement(timestampDomain);
//            }
//        }
//        return Optional.ofNullable(domain);
//    }
}
