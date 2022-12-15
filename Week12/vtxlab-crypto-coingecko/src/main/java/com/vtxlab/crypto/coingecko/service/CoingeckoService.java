package com.vtxlab.crypto.coingecko.service;

import java.util.HashMap;
import java.util.List;

import com.vtxlab.crypto.coingecko.exception.ApiException;
import com.vtxlab.crypto.coingecko.model.CoinsCurrency;
import com.vtxlab.crypto.coingecko.model.CoinsMarkets;

public interface CoingeckoService {

  List<CoinsMarkets> getAllCoinsMarkets() throws ApiException;

  HashMap<String, CoinsCurrency> getSimplePrices(List<String> cryptos,
      List<String> currencies) throws ApiException;

}
