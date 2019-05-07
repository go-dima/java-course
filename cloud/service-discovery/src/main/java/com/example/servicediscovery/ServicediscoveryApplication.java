package com.example.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServicediscoveryApplication {

	public static void main(String[] args) {
		// https://localhost:2000
		SpringApplication.run(ServicediscoveryApplication.class, args);
	}
}
