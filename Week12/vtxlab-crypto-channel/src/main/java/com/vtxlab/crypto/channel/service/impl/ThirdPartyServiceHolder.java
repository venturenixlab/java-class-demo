package com.vtxlab.crypto.channel.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.dto.ChannelDto;
import com.vtxlab.crypto.channel.service.ThirdPartyService;
import com.vtxlab.crypto.channel.utils.ChannelApi;

@Service
// Approach 1
public class ThirdPartyServiceHolder implements ThirdPartyService {

  @Autowired
  ChannelApi channelApi;

  @Override
  public ChannelDto getThirdPartyExchangeRates(List<String> cryptos,
      List<String> currencies, String baseUrl, String serviceVers,
      String serviceUrl) throws ApiException {

    HashMap<String, String> hmap = new HashMap<>();
    hmap.put("cryptos", String.join(",", cryptos));
    hmap.put("currencies", String.join(",", currencies));

    return channelApi.invoke(baseUrl,
        serviceVers, serviceUrl,
        hmap, ChannelDto.class);
  }
}
