package com.vtxlab.demo.bookstore.config;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
  /*
   * @Bean(name = "restTemplate")
   * public RestTemplate poolingRestTemplate(RestTemplateBuilder builder) {
   * PoolingHttpClientConnectionManager
   * }
   */
}
