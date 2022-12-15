package com.vtxlab.crypto.polygon.service;

import java.util.List;

import com.vtxlab.crypto.polygon.exception.ApiException;
import com.vtxlab.crypto.polygon.model.CoinExchange;

public interface PolygonService {

  List<CoinExchange> getCoinExchangeList(List<String> cryptos,
      List<String> currencies) throws ApiException;

}
