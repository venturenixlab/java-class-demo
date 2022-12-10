package com.vtxlab.demo.openweather.service.impl;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.openweather.exception.ApiException;
import com.vtxlab.demo.openweather.model.currentweather.CurrentWeatherResponse;
import com.vtxlab.demo.openweather.service.OpenWeatherService;
import com.vtxlab.demo.openweather.utils.RedisKey;
import com.vtxlab.demo.openweather.utils.WeatherApi;

@Service
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

  @Override
  public CurrentWeatherResponse getCurrentWeather(BigDecimal latitude,
      BigDecimal longitude) throws ApiException {

    // Invoke Weather API
    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("lat", latitude.toString());
    hMap.put("lon", longitude.toString());
    hMap.put("appId", appId);

    String redisKey = RedisKey.API_OPENWEATHER_1 + ":"
        + latitude.toString() + ":"
        + longitude.toString();

    CurrentWeatherResponse currentWeatherResponse = //
        weatherApi.invoke(baseUrl,
            serviceVers, serviceUrl,
            hMap, CurrentWeatherResponse.class,
            redisKey, Duration.ofSeconds(60));

    return currentWeatherResponse;
  }

}
