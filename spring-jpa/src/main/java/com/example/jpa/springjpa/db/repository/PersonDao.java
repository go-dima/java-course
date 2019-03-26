package com.example.jpa.springjpa.db.repository;

import com.example.jpa.springjpa.db.entity.Person;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@NoArgsConstructor
public class PersonDao {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public long addPerson(Person p){
        entityManager.persist(p);
        return p.getId();
    }

    public Person getPerson(long id) {
        return entityManager.find(Person.class, id);
    }
}
