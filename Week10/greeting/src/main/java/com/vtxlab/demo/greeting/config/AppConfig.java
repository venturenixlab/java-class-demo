package com.vtxlab.demo.greeting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration // @Component
public class AppConfig {

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

}
