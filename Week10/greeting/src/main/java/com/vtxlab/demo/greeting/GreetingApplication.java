package com.vtxlab.demo.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Component scan
public class GreetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}

}
