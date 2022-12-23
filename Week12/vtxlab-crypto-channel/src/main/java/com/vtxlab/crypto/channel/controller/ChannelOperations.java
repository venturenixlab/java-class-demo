package com.vtxlab.crypto.channel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.dto.ChannelDto;

@RequestMapping("default")
public interface ChannelOperations {

  @GetMapping(value = "/web/ex-rate")
  ChannelDto getWebExchangeRate(List<String> cryptos,
      List<String> currencies) throws ApiException;

  @GetMapping(value = "/app/ex-rate")
  ChannelDto getAppExchangeRate(List<String> cryptos, List<String> currencies)
      throws ApiException;

}
