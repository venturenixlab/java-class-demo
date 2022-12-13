package com.vtxlab.crypto.coingecko.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.crypto.coingecko.controller.CoingeckoOperations;
import com.vtxlab.crypto.coingecko.exception.ApiException;
import com.vtxlab.crypto.coingecko.model.CoinsMarkets;
import com.vtxlab.crypto.coingecko.service.CoingeckoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/crypto/api/v1")
@Slf4j
public class CoingeckoController implements CoingeckoOperations {

  @Autowired
  CoingeckoService coingeckoService;

  @Override
  public List<CoinsMarkets> getCoinsMarkets() throws ApiException {
    log.info("start Controller");
    List<CoinsMarkets> coinsMarkets = coingeckoService.getAllCoinsMarkets();
    log.info("end Controller: {}", coinsMarkets);
    return coinsMarkets;
  }
}
