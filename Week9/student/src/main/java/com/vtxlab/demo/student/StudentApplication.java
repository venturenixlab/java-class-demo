package com.vtxlab.demo.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // = 
// @SpringBootConfiguration (@Configuration) +
// @ComponentScan
// @EnableAutoConfiguration (TBC) +
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
