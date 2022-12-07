package com.vtxlab.demo.openweather.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.openweather.exception.ApiException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WeatherApi {

  @Autowired
  RestTemplate restTemplate;

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
