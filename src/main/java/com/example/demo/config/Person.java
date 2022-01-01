package com.example.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @create 2022-01-01 20:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    public String name;
    private Integer age;
    private String sex;
}
