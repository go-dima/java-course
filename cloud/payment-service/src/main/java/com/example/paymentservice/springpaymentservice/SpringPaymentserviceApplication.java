package com.example.paymentservice.springpaymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPaymentserviceApplication {

	public static void main(String[] args) {
		// http://localhost:{port}/paymentservice
		SpringApplication.run(SpringPaymentserviceApplication.class, args);
	}
}
