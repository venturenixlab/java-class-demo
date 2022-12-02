package com.vtxlab.demo.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class BookstoreApplication {

	private static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(BookstoreApplication.class,
				args);
		// displayAllBeans();
	}

	public static void displayAllBeans() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		for (String s : allBeanNames) {
			log.info("Bean={}", s);
		}
	}
}
