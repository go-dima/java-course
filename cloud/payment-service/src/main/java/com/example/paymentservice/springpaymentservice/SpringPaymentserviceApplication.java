package com.example.paymentservice.springpaymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringPaymentserviceApplication {

	public static void main(String[] args) {
		// http://localhost:{port}/paymentservice
		SpringApplication.run(SpringPaymentserviceApplication.class, args);
	}
}
