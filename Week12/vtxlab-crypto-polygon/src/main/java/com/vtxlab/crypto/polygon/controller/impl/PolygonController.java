package com.vtxlab.crypto.polygon.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.crypto.polygon.controller.PolygonOperations;
import com.vtxlab.crypto.polygon.exception.ApiException;
import com.vtxlab.crypto.polygon.model.dto.ChannelDto;
import com.vtxlab.crypto.polygon.service.PolygonService;
import com.vtxlab.crypto.polygon.utils.CoinsApi;

@RestController
@RequestMapping(value = "/crypto/polygon/api/v1")
public class PolygonController implements PolygonOperations {

  @Autowired
  PolygonService polygonService;

  @Override
  public ChannelDto getExchangeRate(List<String> cryptos,
      List<String> currencies) throws ApiException {

    return ChannelDto.builder().exchangeRates(
        CoinsApi.map(polygonService.getCoinExchangeList(cryptos, currencies)))
        .build();
  }
}
