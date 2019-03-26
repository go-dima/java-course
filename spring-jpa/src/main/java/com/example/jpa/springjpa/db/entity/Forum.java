package com.example.jpa.springjpa.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Forum {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Person> members;

    public Forum(String name, HashSet<Person> members) {
        this.name = name;
        this.members = members;
    }
}
