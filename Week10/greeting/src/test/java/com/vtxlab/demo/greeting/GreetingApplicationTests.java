package com.vtxlab.demo.greeting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vtxlab.demo.greeting.controller.GreetingOperation;
import com.vtxlab.demo.greeting.service.GreetingService;

// TDD, test driven design
@SpringBootTest // pretend the exact Springboot Application startup situation
// in this example, controller + service will be created in spring context
class GreetingApplicationTests {

	@Autowired
	GreetingOperation greetingOperation;

	@Autowired
	GreetingService greetingService;

	@Test // represents this method will be run automatically for this test case
	void contextLoads() {
		// Mockito, Junit 5
		Assertions.assertThat(greetingOperation).isNotNull();
		Assertions.assertThat(greetingService).isNotNull();
	}
	// "java.completion.favoriteStaticMembers": [
	// "org.assertj.core.api.Assertions.*",
	// "org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*",
	// "org.springframework.test.web.servlet.result.MockMvcResultMatchers.*",
	// ],
}
