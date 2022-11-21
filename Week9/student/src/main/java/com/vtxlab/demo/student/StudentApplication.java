package com.vtxlab.demo.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.vtxlab.demo.student.entity.Student;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication // =
// @SpringBootConfiguration (@Configuration) + // it try to find any bean has to
// be configured in spring container
// @ComponentScan +
// @EnableAutoConfiguration (TBC)
@Slf4j
public class StudentApplication {

	private static ConfigurableApplicationContext applicationContext;

	@Bean(name = "beanForVincent")
	public Student getVincent() {
		return new Student(1l, 150.d, "vincent.lau");
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(StudentApplication.class, args);
		displayAllBeans();
	}

	public static void displayAllBeans() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		for (String s : allBeanNames) {
			log.info("Bean={}", s);
		}
	}

}
