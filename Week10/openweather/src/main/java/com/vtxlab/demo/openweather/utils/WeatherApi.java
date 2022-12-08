package com.vtxlab.demo.openweather.utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.openweather.exception.ApiException;
import com.vtxlab.demo.openweather.model.currentweather.CurrentWeatherResponse;
import com.vtxlab.demo.openweather.model.interfaces.WeatherResponseInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WeatherApi {

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  RedisTemplate<String, WeatherResponseInterface> redisTemplate;

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
      // if (weatherResponse instanceof WeatherResponseInterface) throw something();
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

    return (T) weatherResponse;
  }

  public <T> T invoke(String baseUrl, String serviceVers,
      String serviceUrl, HashMap<String, String> queryParms,
      Class<T> returnType) throws ApiException {
    try {
      UriComponentsBuilder url = UriComponentsBuilder.fromUriString(baseUrl)
          .pathSegment(serviceVers)
          .path(serviceUrl);

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
