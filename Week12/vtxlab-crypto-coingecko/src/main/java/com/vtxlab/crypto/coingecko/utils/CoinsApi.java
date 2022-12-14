package com.vtxlab.crypto.coingecko.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.crypto.coingecko.exception.ApiException;
import com.vtxlab.crypto.coingecko.model.CoinsCurrency;
import com.vtxlab.crypto.coingecko.model.CoinsCurrencyMap;
import com.vtxlab.crypto.coingecko.model.CoinsGeckoModel;
import com.vtxlab.crypto.coingecko.model.CoinsMarkets;
import com.vtxlab.crypto.coingecko.model.dto.ChannelDto;
import com.vtxlab.crypto.coingecko.model.dto.ChannelDto.ExchangeRate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CoinsApi {

  @Autowired
  RestTemplate restTemplate;

  public static List<ChannelDto.ExchangeRate> map(
      Map<String, CoinsCurrency> coinsCurrencyMap) {

    List<ChannelDto.ExchangeRate> exchangeRates = new ArrayList<>();

    for (Map.Entry<String, CoinsCurrency> entry : coinsCurrencyMap.entrySet()) {
      // Set Crypto to USD
      ExchangeRate exchangeRate = new ChannelDto().new ExchangeRate();
      exchangeRate.setFromCurr(entry.getKey());
      exchangeRate.setToCurr("USD");
      exchangeRate.setRate(entry.getValue().getUsd());
      exchangeRates.add(exchangeRate);
      // Set Crypto to HKD
      exchangeRate = new ChannelDto().new ExchangeRate();
      exchangeRate.setFromCurr(entry.getKey());
      exchangeRate.setToCurr("HKD");
      exchangeRate.setRate(entry.getValue().getHkd());
      exchangeRates.add(exchangeRate);

      // Set USD to Crypto
      exchangeRate = new ChannelDto().new ExchangeRate();
      exchangeRate.setFromCurr("USD");
      exchangeRate.setToCurr(entry.getKey());
      exchangeRate.setRate(BigDecimal.ONE.divide(entry.getValue().getUsd(),
          new MathContext(6, RoundingMode.UP)));
      exchangeRates.add(exchangeRate);
      // Set HKD to Crypto
      exchangeRate = new ChannelDto().new ExchangeRate();
      exchangeRate.setFromCurr("HKD");
      exchangeRate.setToCurr(entry.getKey());
      exchangeRate.setRate(BigDecimal.ONE.divide(entry.getValue().getHkd(),
          new MathContext(6, RoundingMode.UP)));
      exchangeRates.add(exchangeRate);
    }
    return exchangeRates;
  }

  public <T> T invoke(String baseUrl,
      String serviceVers,
      String serviceUrl, HashMap<String, String> queryParms,
      Class<T> returnType) throws ApiException {
    try {
      // url = https://api.coingecko.com/api/v3/coins/markets
      UriComponentsBuilder url = UriComponentsBuilder.fromUriString(baseUrl)
          .pathSegment(serviceVers) // api/v3
          .path(serviceUrl); // coins/markets

      // construct params to url
      // concat
      // "?vs_currency=usd&per_page=100&page=1&order=market_cap_desc&sparkline=false"
      for (Map.Entry<String, String> entry : queryParms.entrySet()) {
        url = url.queryParam(entry.getKey(), entry.getValue());
      }
      // https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&per_page=100&page=1&order=market_cap_desc
      String urlString = url.build().toString();

      log.info("url={}", urlString);

      // invoke coingecko api with pre-defined return type (CoinsMarkats)
      return restTemplate.getForObject(urlString, returnType);
    } catch (Exception e) {
      e.printStackTrace();
      throw new ApiException(80001, "Call coinGecko service fail.");
    }
  }

  public <K, V> Map<K, V> invoke2(String baseUrl,
      String serviceVers,
      String serviceUrl, HashMap<String, String> queryParms,
      Class<Map<K, V>> returnType) throws ApiException {
    try {
      // url = https://api.coingecko.com/api/v3/coins/markets
      UriComponentsBuilder url = UriComponentsBuilder.fromUriString(baseUrl)
          .pathSegment(serviceVers) // api/v3
          .path(serviceUrl); // coins/markets

      // construct params to url
      // concat
      // "?vs_currency=usd&per_page=100&page=1&order=market_cap_desc&sparkline=false"
      for (Map.Entry<String, String> entry : queryParms.entrySet()) {
        url = url.queryParam(entry.getKey(), entry.getValue());
      }
      // https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&per_page=100&page=1&order=market_cap_desc
      String urlString = url.build().toString();

      log.info("url={}", urlString);
      // invoke coingecko api with pre-defined return type (CoinsMarkats)
      return restTemplate.getForObject(urlString, returnType);
    } catch (Exception e) {
      e.printStackTrace();
      throw new ApiException(80001, "Call coinGecko service fail.");
    }
  }
}
