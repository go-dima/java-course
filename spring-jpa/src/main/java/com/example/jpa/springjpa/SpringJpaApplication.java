package com.example.jpa.springjpa;

import com.example.jpa.springjpa.db.entity.Person;
import com.example.jpa.springjpa.db.repository.PersonDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpaApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaApplication.class, args);

		PersonDao personDao = ctx.getBean(PersonDao.class);
		Person p1 = new Person("Dima", 29);
		long idP1 = personDao.addPerson(p1);
		System.out.printf("Created person with id %d\n", idP1);
		Person p2 = personDao.getPerson(idP1);
		System.out.println("Got: " + p2);
	}
}
