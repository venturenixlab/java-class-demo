package com.vtxlab.demo.greeting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vtxlab.demo.greeting.controller.GreetingOperation;
import com.vtxlab.demo.greeting.controller.impl.GreetingController;
import com.vtxlab.demo.greeting.service.GreetingService;

// Junit 5
@ExtendWith(SpringExtension.class) // @Mock, @InjectMocks
class GreetingControllerUnitTest {

  @Mock // No implementation injected in this reference
  // Mock the dependency of greetingOperation
  GreetingService greetingService;

  // @InjectMocks
  // private GreetingController greetingController;
  GreetingOperation greetingOperation;

  @BeforeEach
  void setup() {
    greetingOperation = new GreetingController(greetingService);
  }

  void testHelloworld(String input, String output,
      String notEqualOutput) {
    // Mockito
    // Given
    Mockito.when(greetingService.greeting()).thenReturn(input);
    // When
    String string = greetingOperation.greeting();
    // Then
    if (output != null) {
      Assertions.assertThat(string).isEqualTo(output);
    }
    if (notEqualOutput != null) {
      Assertions.assertThat(string).isNotEqualTo(notEqualOutput);
    }
  }

  @Test
  void testCases() {
    // Test Equal and Not Equal
    testHelloworld("hello world", "hello worldd", "hello");
    testHelloworld("", "d", "c");
    testHelloworld("abc", "abcd", "bcda");
    // ... 100 test cases
  }

}
