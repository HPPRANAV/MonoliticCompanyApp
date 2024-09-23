package com.example.firstjobapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstjobappApplication {
	//docker run  -p 8080:8080 --name firstjobapp-container firstjobapp:latest

	public static void main(String[] args) {
		SpringApplication.run(FirstjobappApplication.class, args);

	}

}
