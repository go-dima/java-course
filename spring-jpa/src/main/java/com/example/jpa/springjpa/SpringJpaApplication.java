package com.example.jpa.springjpa;

import com.example.jpa.springjpa.db.entity.Forum;
import com.example.jpa.springjpa.db.entity.Person;
import com.example.jpa.springjpa.db.repository.ForumDao;
import com.example.jpa.springjpa.db.repository.PersonDao;
import com.example.jpa.springjpa.db.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringJpaApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaApplication.class, args);

//		TestPersonDao(ctx);
//		TestForumDao(ctx);
		TestPersonRepo(ctx);
	}

	private static void TestPersonRepo(ConfigurableApplicationContext ctx) {
		PersonRepository personRepo = ctx.getBean(PersonRepository.class);
		Person p1 = new Person("Dima", 29);
		Person p2 = new Person("Bob", 38);
		Person p3 = new Person("Alice", 27);
		personRepo.save(p1);
		personRepo.save(p2);
		personRepo.save(p3);

		System.out.printf("Created person with id %d\n", p1.getId());
		Person p1_out = personRepo.findOne(p1.getId());
		System.out.println("Got: " + p1_out);

		Set<Person> byAgeBetween = personRepo.findByAgeBetween(28, 40);
		System.out.println(byAgeBetween);
	}

	private static void TestForumDao(ConfigurableApplicationContext ctx) {
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

	private static void TestPersonDao(ConfigurableApplicationContext ctx) {
		PersonDao personDao = ctx.getBean(PersonDao.class);
		Person p1 = new Person("Dima", 29);
		long idP1 = personDao.addPerson(p1);
		System.out.printf("Created person with id %d\n", idP1);
		Person p2 = personDao.getPerson(idP1);
		System.out.println("Got: " + p2);
	}
}
