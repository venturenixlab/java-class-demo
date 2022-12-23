package com.vtxlab.crypto.channel.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.crypto.channel.controller.ChannelOperations;
import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.dto.ChannelDto;
import com.vtxlab.crypto.channel.service.OrchestrationService;

@RestController
@RequestMapping(value = "/crypto/channel/api/v1")
public class ChannelController implements ChannelOperations {
  @Autowired
  OrchestrationService orchestrationService;

  @Override
  public ChannelDto getWebExchangeRate(List<String> cryptos,
      List<String> currencies) throws ApiException {
    return orchestrationService.getExchangeRates(cryptos, currencies,
        "crypto-web");
  }

  @Override
  public ChannelDto getAppExchangeRate(List<String> cryptos,
      List<String> currencies) throws ApiException {
    return orchestrationService.getExchangeRates(cryptos, currencies,
        "crypto-app");
  }
}
