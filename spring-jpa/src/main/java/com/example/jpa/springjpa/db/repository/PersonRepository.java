package com.example.jpa.springjpa.db.repository;

import com.example.jpa.springjpa.db.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Set<Person> findByAgeBetween(int fromAge, int toAge);
}
