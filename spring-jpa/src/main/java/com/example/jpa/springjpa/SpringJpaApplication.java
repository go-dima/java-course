package com.example.jpa.springjpa;

import com.example.jpa.springjpa.db.entity.Forum;
import com.example.jpa.springjpa.db.entity.Person;
import com.example.jpa.springjpa.db.repository.ForumDao;
import com.example.jpa.springjpa.db.repository.PersonDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;

@SpringBootApplication
public class SpringJpaApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaApplication.class, args);

//		TestPerson(ctx);
		TestForum(ctx);
	}

	private static void TestForum(ConfigurableApplicationContext ctx) {
		PersonDao personDao = ctx.getBean(PersonDao.class);
		ForumDao forumDao = ctx.getBean(ForumDao.class);

		Person p1 = new Person("Dima", 29);
		Person p2 = new Person("Arik", 1);

		HashSet<Person> people = new HashSet<>();
		people.add(p2);
		people.add(p1);

		Forum forum = new Forum("People", people);
		forumDao.addForum(forum);
	}

	private static void TestPerson(ConfigurableApplicationContext ctx) {
		PersonDao personDao = ctx.getBean(PersonDao.class);
		Person p1 = new Person("Dima", 29);
		long idP1 = personDao.addPerson(p1);
		System.out.printf("Created person with id %d\n", idP1);
		Person p2 = personDao.getPerson(idP1);
		System.out.println("Got: " + p2);
	}
}
