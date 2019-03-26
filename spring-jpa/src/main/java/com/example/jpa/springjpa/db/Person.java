package com.example.jpa.springjpa.db;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@ToString(of={"name","age"})
public class Person {
    @Id
    @GeneratedValue
    private long Id;

    @Column
    private String name;

    @Column
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
