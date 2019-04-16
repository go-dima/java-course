package com.example.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RabbitApplication.class, args);
	}

	@Autowired
	private Producer sender;

	@Autowired
	private RabbitConf conf;

	@Override
	public void run(String... strings) throws Exception {
		sender.send(conf.routingKeyA, "***  MESSAGE 1 ***");
		sender.send(conf.routingKeyB, "***  MESSAGE 2 ***");
		try{
			Thread.sleep(5000);
		}
		catch(Exception e){}
		sender.send(conf.routingKeyA, "***  MESSAGE 3 ***");
	}
}
