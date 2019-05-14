package com.example.streaming;

import com.example.streaming.beans.HobbitFlux;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StreamingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StreamingApplication.class, args);

		HobbitFlux book = context.getBean(HobbitFlux.class);
		book.getHobbitVod().subscribe(System.out::println);
		System.out.println("-------------------------------------------------");

		try { Thread.sleep(10 * 1000); } catch (Exception e) { }

		book.getHobbitLive().subscribe(System.out::println);
	}
}
