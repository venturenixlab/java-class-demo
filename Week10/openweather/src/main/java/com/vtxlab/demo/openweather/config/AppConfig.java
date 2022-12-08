package com.vtxlab.demo.openweather.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vtxlab.demo.openweather.response.Alert;

@Configuration
public class AppConfig {

  @Bean(name = "alerts")
  public List<Alert> alerts() {
    return new ArrayList<>();
  }
}
