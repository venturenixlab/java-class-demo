package com.vtxlab.crypto.channel.service;

import java.util.List;

import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.dto.ChannelDto;

public interface OrchestrationService {

  ChannelDto getExchangeRates(List<String> cryptos,
      List<String> currencies, String sourceApp) throws ApiException;

}
