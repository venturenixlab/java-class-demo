package com.vtxlab.demo.openweather.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.openweather.exception.ApiException;
import com.vtxlab.demo.openweather.model.dto.CurrentWeatherDto;
import com.vtxlab.demo.openweather.model.dto.WeatherDto;
import com.vtxlab.demo.openweather.model.interfaces.WeatherResponseInterface;
import com.vtxlab.demo.openweather.response.Alert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WeatherApi {

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  RedisTemplate<String, WeatherResponseInterface> redisTemplate;

  static List<Alert> alerts = new ArrayList<>();

  public static List<Alert> getAlerts() {
    return alerts;
  }

  public static void setAlerts(Alert alert) {
    alerts.add(alert);
  }

  /**
   * 
   * @param <T>
   * @param baseUrl
   * @param serviceVers
   * @param serviceUrl
   * @param queryParms
   * @param returnType
   * @param redisKey
   * @param redisKeyDuration
   * @return
   * @throws ApiException
   */
  public <T extends WeatherResponseInterface> T invoke(String baseUrl,
      String serviceVers,
      String serviceUrl, HashMap<String, String> queryParms,
      Class<T> returnType, String redisKey, Duration redisKeyDuration)
      throws ApiException {
    // Check if the redisKey still exist in redis database
    WeatherResponseInterface weatherResponse = //
        redisTemplate.opsForValue().get(redisKey);

    if (weatherResponse != null) {
      // if (weatherResponse instanceof WeatherResponseInterface) throw
      // something();
      return (T) weatherResponse;
    }
    // Invoke API
    weatherResponse = invoke(baseUrl, serviceVers,
        serviceUrl, queryParms,
        returnType);
    // Set to redis by Duration
    redisTemplate.opsForValue().set(redisKey,
        weatherResponse,
        redisKeyDuration);

    WeatherDto weatherDto = new WeatherDto(new CurrentWeatherDto());

    return (T) weatherResponse;
  }

  public <T extends WeatherResponseInterface> T invoke(String baseUrl,
      String serviceVers,
      String serviceUrl, HashMap<String, String> queryParms,
      Class<T> returnType) throws ApiException {
    try {
      UriComponentsBuilder url = UriComponentsBuilder.fromUriString(baseUrl)
          .pathSegment(serviceVers) // data/2.5
          .path(serviceUrl); // weather

      // http://xxx.com/data/2.5/weather?lat=22&lon=115&appId=12345
      for (Map.Entry<String, String> entry : queryParms.entrySet()) {
        url = url.queryParam(entry.getKey(), entry.getValue());
      }

      String urlString = url.build().toString();

      log.info("url={}", urlString);

      return restTemplate.getForObject(urlString, returnType);

    } catch (Exception e) {
      e.printStackTrace();
      throw new ApiException(80001, "Call Open-weather service fail.");
    }
  }

}
