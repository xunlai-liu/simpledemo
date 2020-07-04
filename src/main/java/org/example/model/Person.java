package org.example.model;

import org.springframework.context.annotation.Bean;

/**
 * @author xunlailiu
 * @date 2020/05/20
 */

public class Person {

    public Person(){}

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
