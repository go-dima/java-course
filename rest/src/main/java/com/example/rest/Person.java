package com.example.rest;

import lombok.Getter;
import lombok.Setter;

public class Person {
    @Getter @Setter private String name;
    @Getter @Setter private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
