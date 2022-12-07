package com.vtxlab.demo.openweather.service.impl;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.openweather.exception.ApiException;
import com.vtxlab.demo.openweather.model.currentweather.CurrentWeatherResponse;
import com.vtxlab.demo.openweather.service.OpenWeatherService;
import com.vtxlab.demo.openweather.utils.RedisKey;
import com.vtxlab.demo.openweather.utils.WeatherApi;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OpenWeatherServiceHolder implements OpenWeatherService {

  @Autowired
  WeatherApi weatherApi;

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

    CurrentWeatherResponse currentWeatherResponse = //
        redisTemplate.opsForValue().get(RedisKey.API_OPENWEATHER_1);

    // Check if the currentWeather response still exist in Redis
    // If yes, return;
    if (currentWeatherResponse != null) {
      return currentWeatherResponse;
    }

    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("lat", latitude.toString());
    hMap.put("lon", longitude.toString());
    hMap.put("appId", appId);
    currentWeatherResponse = weatherApi.invoke(baseUrl,
        serviceVers, serviceUrl,
        hMap, CurrentWeatherResponse.class);

    // Set to Redis with 10 minutes expiry
    redisTemplate.opsForValue().set(RedisKey.API_OPENWEATHER_1,
        currentWeatherResponse,
        Duration.ofSeconds(600));
        
    return currentWeatherResponse;
  }

}
