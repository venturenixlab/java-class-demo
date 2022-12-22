package com.vtxlab.crypto.channel.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vtxlab.crypto.channel.service.ThirdPartyService2;

@Component
public class ThirdPartyServiceFactory {

  @Autowired
  @Qualifier("coingeckoService")
  ThirdPartyService2 coingeckoService;

  @Autowired
  @Qualifier("polygonService")
  ThirdPartyService2 polygonService;

  public ThirdPartyService2 produceThirdPartyService(String sourceApp) {
    return switch (sourceApp) {
      case "crypto-web" -> coingeckoService;
      case "crypto-app" -> polygonService;
      default -> null;
    };
  }

}
