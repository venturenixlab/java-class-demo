package com.vtxlab.demo.greeting;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import com.vtxlab.demo.greeting.service.GreetingService;

@WebMvcTest
// Start spring context, but with Controller related bean ONLY
public class GreetingControllerIntegrationTest {

  @MockBean // Create a new bean to spring context
  GreetingService greetingService;

  @Autowired
  // Due to @WebMvcTest, the mockMvc Bean has been loaded to context
  MockMvc mockMvc;

  @Test
  void testWebMvc() throws Exception {
    // Given
    Mockito.when(greetingService.greeting()).thenReturn("hello world");
    // When
    MockHttpServletRequestBuilder builder = //
        MockMvcRequestBuilders.get("/api/v1/greeting");
    // Execute the call
    ResultActions response = mockMvc.perform(builder);
    // check if the http response is 200
    StatusResultMatchers status = MockMvcResultMatchers.status();
    ResultMatcher statusOk = status.isOk(); // 200
    response.andExpect(statusOk);

    ContentResultMatchers content = MockMvcResultMatchers.content();
    ResultMatcher contentHelloworld = content.string("hello worldd");
    response.andExpect(contentHelloworld);

    // "org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*",
    // "org.springframework.test.web.servlet.result.MockMvcResultMatchers.*",
  }

  @Test
  void testWebMvc2() throws Exception {
    when(greetingService.greeting()).thenReturn("hello world");
    mockMvc.perform(get("/api/v1/greeting")) //
        .andExpect(status().isOk())
        .andExpect(content().string("hello worldd"));
  }

}
