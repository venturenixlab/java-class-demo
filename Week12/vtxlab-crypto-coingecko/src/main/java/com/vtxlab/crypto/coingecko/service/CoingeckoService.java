package com.vtxlab.crypto.coingecko.service;

import java.util.List;

import com.vtxlab.crypto.coingecko.exception.ApiException;
import com.vtxlab.crypto.coingecko.model.CoinsMarkets;

public interface CoingeckoService {

  List<CoinsMarkets> getAllCoinsMarkets() throws ApiException;
  
}
