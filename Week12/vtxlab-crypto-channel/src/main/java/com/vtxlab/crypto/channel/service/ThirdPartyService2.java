package com.vtxlab.crypto.channel.service;

import java.util.List;

import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.dto.ChannelDto;

// Approach 2
public interface ThirdPartyService2 {

  ChannelDto getThirdPartyExchangeRates(List<String> cryptos,
      List<String> currencies) throws ApiException;
}
