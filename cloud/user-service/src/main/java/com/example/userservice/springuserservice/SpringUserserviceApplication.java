package com.example.userservice.springuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringUserserviceApplication {

	public static void main(String[] args) {
		// http://localhost:8001/userservice
		SpringApplication.run(SpringUserserviceApplication.class, args);
	}
}
