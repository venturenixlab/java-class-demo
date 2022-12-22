package com.vtxlab.crypto.channel.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.ChannelCoinMapping;
import com.vtxlab.crypto.channel.model.dto.ChannelDto;
import com.vtxlab.crypto.channel.service.AdminService;
import com.vtxlab.crypto.channel.service.ThirdPartyService2;
import com.vtxlab.crypto.channel.utils.ChannelApi;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PolygonService implements ThirdPartyService2 {

  @Autowired
  AdminService adminService;

  @Autowired
  ChannelApi channelApi;

  final static String TRAN_TYPE_EX_RATE = "ex-rate";
  final static String CHANNEL_CODE_POLYGON = "polygon";

  @Value("${service.polygon.baseUrl}")
  String baseUrl;
  @Value("${service.polygon.serviceVers}")
  String serviceVers;
  @Value("${service.polygon.serviceUrl}")
  String serviceUrl;

  @Override
  public ChannelDto getThirdPartyExchangeRates(List<String> cryptos,
      List<String> currencies) throws ApiException {

    List<ChannelCoinMapping> coinMappings = adminService
        .getChannelByChannelCode(CHANNEL_CODE_POLYGON).getCoinMaps();

    // cryptos = [BTC, USDT]
    // coinMappings = [{BTC, bitcoin}, {USDT, tether}, ... N objects]
    List<String> coins = cryptos.stream()
        .map(coin -> {
          // line 52-54, find {BTC, bitcoin} by BTC, and return bitcoin
          return coinMappings.stream()
              .filter(m -> m.getCoinCode() == coin)
              .map(e -> e.getCoinId()).toString();
        }).collect(Collectors.toList());

    log.info("coins={}", coins);
    String concatCoins = String.join(",", coins); // bitcoin, tether
    String concatCurrencies = String.join(",", currencies); // USD

    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("coins", concatCoins);
    hMap.put("currencies", concatCurrencies);

    return channelApi.invoke(baseUrl,
        serviceVers, serviceUrl,
        hMap, ChannelDto.class);

  }
}
