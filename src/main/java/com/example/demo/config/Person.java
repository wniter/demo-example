package com.example.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2022-01-01 20:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    public String name;
    private Integer age;

    public static List<Person> getList() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Ram", 30));
        list.add(new Person("Shyam", 20));
        list.add(new Person("Shiv", 20));
        list.add(new Person("Mahesh", 30));
        return list;
    }
}
