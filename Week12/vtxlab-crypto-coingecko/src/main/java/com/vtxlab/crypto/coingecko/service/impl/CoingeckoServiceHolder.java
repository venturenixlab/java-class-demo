package com.vtxlab.crypto.coingecko.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vtxlab.crypto.coingecko.exception.ApiException;
import com.vtxlab.crypto.coingecko.model.CoinsMarkets;
import com.vtxlab.crypto.coingecko.service.CoingeckoService;
import com.vtxlab.crypto.coingecko.utils.CoinsApi;

@Service
public class CoingeckoServiceHolder implements CoingeckoService {

  @Autowired
  CoinsApi coinsApi;

  @Value("${coingecko.baseUrl}")
  String baseUrl;
  @Value("${coingecko.serviceVers}")
  String serviceVers;
  @Value("${coingecko.service.coins-markets.serviceUrl}")
  String serviceUrl;
  @Value("${coingecko.service.coins-markets.currency}")
  String vsCurrency;
  @Value("${coingecko.service.coins-markets.order}")
  String order;
  @Value("${coingecko.service.coins-markets.perPage}")
  String perPage;
  @Value("${coingecko.service.coins-markets.page}")
  String page;
  @Value("${coingecko.service.coins-markets.sparkline}")
  String sparkline; // boolean

  @Override
  public List<CoinsMarkets> getAllCoinsMarkets() throws ApiException {

    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("vs_currency", vsCurrency);
    hMap.put("order", order);
    hMap.put("per_page", perPage);
    hMap.put("page", page);
    hMap.put("sparkline", sparkline);

    return Arrays.asList(coinsApi.invoke(baseUrl,
        serviceVers, serviceUrl,
        hMap, CoinsMarkets[].class));

  };

}
