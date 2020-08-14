package com.spring.ioc.dependencies.domain;

/**
 * @program: geekbang-lessons
 * @description:
 * @author: Jay
 * @create: 2020-08-05 23:18
 **/

public class User {
    private Integer age;

    private String name;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
