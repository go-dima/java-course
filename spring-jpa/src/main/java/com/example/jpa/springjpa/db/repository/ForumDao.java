package com.example.jpa.springjpa.db.repository;

import com.example.jpa.springjpa.db.entity.Forum;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@NoArgsConstructor
public class ForumDao {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public long addForum(Forum f){
        entityManager.persist(f);
        return f.getId();
    }
}
