package com.vtxlab.crypto.channel.service;

import java.util.HashMap;
import java.util.List;

import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.dto.ChannelDto;

public interface ThirdPartyService {

  ChannelDto getThirdPartyExchangeRates(List<String> cryptos,
      List<String> currencies, String baseUrl, String serviceVers,
      String serviceUrl) throws ApiException;

}
