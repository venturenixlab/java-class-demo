package com.vtxlab.crypto.coingecko.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.crypto.coingecko.exception.ApiException;
import com.vtxlab.crypto.coingecko.model.CoinsMarkets;
import com.vtxlab.crypto.coingecko.model.dto.ChannelDto;

@RequestMapping(value = "/default")
public interface CoingeckoOperations {

  @GetMapping(value = "/coingecko/coin/market")
  List<CoinsMarkets> getCoinsMarkets() throws ApiException;

  @GetMapping(value = "/coingecko/simple-price")
  ChannelDto getSimplePrices(@RequestParam("coins") List<String> cryptos,
      @RequestParam("currency") List<String> currencies)
      throws ApiException;

  @GetMapping(value = "/splitcomma")
  public List<String> stringToList(@RequestParam("coins") List<String> coins);

}
