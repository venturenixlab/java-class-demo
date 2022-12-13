package com.vtxlab.crypto.coingecko.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.crypto.coingecko.exception.ApiException;
import com.vtxlab.crypto.coingecko.model.CoinsGeckoModel;
import com.vtxlab.crypto.coingecko.model.CoinsMarkets;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CoinsApi {

  @Autowired
  RestTemplate restTemplate;

  public <T extends CoinsMarkets> T[] invoke(String baseUrl,
      String serviceVers,
      String serviceUrl, HashMap<String, String> queryParms,
      Class<T[]> returnType) throws ApiException {
    try {
      UriComponentsBuilder url = UriComponentsBuilder.fromUriString(baseUrl)
          .pathSegment(serviceVers) // api/v3
          .path(serviceUrl); // coins/markets

      for (Map.Entry<String, String> entry : queryParms.entrySet()) {
        url = url.queryParam(entry.getKey(), entry.getValue());
      }

      String urlString = url.build().toString();

      log.info("url={}", urlString);

      return restTemplate.getForObject(urlString, returnType);
    } catch (Exception e) {
      e.printStackTrace();
      throw new ApiException(80001, "Call coinGecko service fail.");
    }
  }
}
