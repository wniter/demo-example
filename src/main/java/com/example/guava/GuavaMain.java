package com.example.guava;

import com.google.common.base.Joiner;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @create 2022-03-19 2:56
 */
public class GuavaMain {

    public static void main(String[] args) {
//        guavaCache();

        guavaString();

    }

    public static void guavaCache() {
        LoadingCache<String, BigDecimal> cache = CacheBuilder.newBuilder()
                .maximumSize(10).refreshAfterWrite(10, TimeUnit.MINUTES)
                .softValues() //软引用
                .expireAfterWrite(1, TimeUnit.DAYS)
                .build(new CacheLoader<String, BigDecimal>() {
                    @Override
                    public BigDecimal load(String key) throws Exception {
                        return new BigDecimal(0);
                    }
                });
        String s = cache.toString();
        System.out.println(s);

    }

    static void guavaString() {
        List<String> list = Lists.newArrayList("a", "b", "c");
        String value = Joiner.on("-").skipNulls().join(list);
        System.out.println(value);
    }
}
