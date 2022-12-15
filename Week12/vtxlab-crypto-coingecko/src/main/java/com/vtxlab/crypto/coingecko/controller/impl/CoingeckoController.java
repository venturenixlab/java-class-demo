package com.vtxlab.crypto.coingecko.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.crypto.coingecko.controller.CoingeckoOperations;
import com.vtxlab.crypto.coingecko.exception.ApiException;
import com.vtxlab.crypto.coingecko.model.CoinsMarkets;
import com.vtxlab.crypto.coingecko.model.dto.ChannelDto;
import com.vtxlab.crypto.coingecko.service.CoingeckoService;
import com.vtxlab.crypto.coingecko.utils.CoinsApi;

import lombok.extern.slf4j.Slf4j;

@RestController
// @CrossOrigin
@RequestMapping(value = "/crypto/api/v1")
public class CoingeckoController implements CoingeckoOperations {

  @Autowired
  CoingeckoService coingeckoService; // interface

  @Override
  public List<CoinsMarkets> getCoinsMarkets() throws ApiException {
    return coingeckoService.getAllCoinsMarkets();
  }

  @Override
  public ChannelDto getSimplePrices(List<String> cryptos,
      List<String> currencies) throws ApiException {

    return ChannelDto.builder().exchangeRates(
        CoinsApi.map(coingeckoService.getSimplePrices(cryptos, currencies)))
        .build();
  }

  @Override
  public List<String> stringToList(List<String> coins) {
    return coins;
  }

  // ....

}
