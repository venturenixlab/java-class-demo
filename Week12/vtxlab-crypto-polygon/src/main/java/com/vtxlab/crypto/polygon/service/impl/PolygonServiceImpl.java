package com.vtxlab.crypto.polygon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vtxlab.crypto.polygon.exception.ApiException;
import com.vtxlab.crypto.polygon.model.CoinExchange;
import com.vtxlab.crypto.polygon.service.PolygonService;
import com.vtxlab.crypto.polygon.utils.CoinsApi;

@Service
public class PolygonServiceImpl implements PolygonService {

  @Autowired
  CoinsApi coinsApi;

  @Value("${polygon.baseUrl}")
  String baseUrl;
  @Value("${polygon.serviceVers}")
  String serviceVers;
  @Value("${polygon.service.previous.serviceUrl}")
  String serviceUrl;
  @Value("${polygon.apiKey}")
  String apiKey;
  @Value("${polygon.service.previous.adjusted}")
  String adjusted;

  @Override
  // cryptos: BTC ETH USDT
  // currencies: USD JPY
  // -> BTCUSD, ETHUSD, USDTUSD, BTCJPY, ETHJPY, USDTJPY
  public List<CoinExchange> getCoinExchangeList(List<String> cryptos,
      List<String> currencies) throws ApiException {
    // Loop cryptos to invoke Polygon API
    List<CoinExchange> coinExchanges = new ArrayList<>();
    for (String coin : cryptos) {
      for (String curr : currencies) {
        coinExchanges.add(getCoinExchange(coin, curr));
      }
    }
    return coinExchanges;
  }

  private CoinExchange getCoinExchange(String crypto, String currency)
      throws ApiException {

    // Originally, serviceUrl = ticker/{ticker}/prev
    // To replace {ticker} by X:BTCUSD ("X:" + crypto + currency)
    // As a result, ticker/X:BTCUSD/prev
    String updatedServiceUrl = serviceUrl.replace("{ticker}",
        "X:" + crypto + currency);

    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("adjusted", adjusted);
    hMap.put("apiKey", apiKey);

    return coinsApi.invoke(baseUrl,
        serviceVers, updatedServiceUrl,
        hMap, CoinExchange.class);
  }

}
