package com.vtxlab.crypto.coingecko.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.crypto.coingecko.exception.ApiException;
import com.vtxlab.crypto.coingecko.model.CoinsMarkets;

@RequestMapping(value = "/default")
public interface CoingeckoOperations {
  
  @GetMapping(value = "/coin/market")
  List<CoinsMarkets> getCoinsMarkets() throws ApiException;
  
}
