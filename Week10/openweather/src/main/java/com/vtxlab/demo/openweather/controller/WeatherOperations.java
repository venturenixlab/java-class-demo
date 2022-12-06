package com.vtxlab.demo.openweather.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.demo.openweather.model.dto.WeatherDto;
import com.vtxlab.demo.openweather.response.ApiResponse;

@RequestMapping(value = "/default")
public interface WeatherOperations {

  @GetMapping(value = "/weather")
  ResponseEntity<ApiResponse<WeatherDto>> getWeatherData(
      @RequestParam(name = "lat") BigDecimal lantitude,
      @RequestParam(name = "lon") BigDecimal longitude) throws Exception;

}
