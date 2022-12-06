package com.vtxlab.demo.openweather.service.impl;

import java.math.BigDecimal;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.openweather.exception.ApiException;
import com.vtxlab.demo.openweather.model.currentweather.CurrentWeatherResponse;
import com.vtxlab.demo.openweather.service.OpenWeatherService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OpenWeatherServiceHolder implements OpenWeatherService {

  @Autowired
  RestTemplate restTemplate;

  @Value("${service.currentweather.baseUrl}")
  String baseUrl;

  @Value("${service.currentweather.serviceVers}")
  String serviceVers;

  @Value("${service.currentweather.serviceUrl}")
  String serviceUrl;

  @Value("${service.appId}")
  String appId;

  @Autowired
  RedisTemplate<String, CurrentWeatherResponse> redisTemplate;

  @Override
  public CurrentWeatherResponse getCurrentWeather(BigDecimal latitude,
      BigDecimal longitude) throws ApiException {

    // key= openweather:currentweather:response
    // value= CurrentWeatherResponse
    String redisKey = "openweather:currentweather:response";

    CurrentWeatherResponse currentWeatherResponse = //
        redisTemplate.opsForValue().get(redisKey);

    if (currentWeatherResponse != null) {
      return currentWeatherResponse;
    }

    try {
      String url = UriComponentsBuilder.fromUriString(baseUrl)
          .pathSegment(serviceVers)
          .path(serviceUrl)
          .queryParam("lat", latitude)
          .queryParam("lon", longitude)
          .queryParam("appid", appId)
          .build()
          // .encode()
          .toString();

      log.info("url={}", url);
      // Call Open-Weather API
      currentWeatherResponse = //
          restTemplate.getForObject(url, CurrentWeatherResponse.class);

      // Set to Redis with 10 minutes expiry
      redisTemplate.opsForValue().set(redisKey,
          currentWeatherResponse,
          Duration.ofSeconds(600));

      return currentWeatherResponse;
    } catch (Exception e) {
      e.printStackTrace();
      // WeatherController.errAlerts
      // .add(new Alert(80001, "Call Open-weather service fail."));
      throw new ApiException(80001, "Call Open-weather service fail.");
    }
  }

}
