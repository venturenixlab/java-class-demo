package com.vtxlab.crypto.channel.service.impl;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.Channel;
import com.vtxlab.crypto.channel.model.ChannelTransaction;
import com.vtxlab.crypto.channel.model.dto.ChannelDto;
import com.vtxlab.crypto.channel.service.AdminService;
import com.vtxlab.crypto.channel.service.OrchestrationService;
import com.vtxlab.crypto.channel.service.ThirdPartyService;

@Service
public class OrchestrationServiceHolder implements OrchestrationService {

  @Autowired
  AdminService adminService;

  @Autowired
  ThirdPartyService thirdPartyService;

  final static String TRAN_TYPE_EX_RATE = "ex-rate";

  @Override
  public ChannelDto getExchangeRates(List<String> cryptos,
      List<String> currencies, String sourceApp) throws ApiException {
    // Invoke Admin Service
    Channel channel = adminService.getChannelBySourceAppAndTranType(sourceApp,
        TRAN_TYPE_EX_RATE);

    // Invoke Third Party API Service
    Predicate<ChannelTransaction> sourceAppCheck = e -> sourceApp
        .equals(e.getSourceApp());
    Predicate<ChannelTransaction> tranTypeCheck = e -> TRAN_TYPE_EX_RATE
        .equals(e.getTranType());

    ChannelTransaction channelTran = channel.getCoinTrans().stream()
        .filter(sourceAppCheck.and(tranTypeCheck)).findFirst()
        .orElse(null);

    ChannelDto channelDto = thirdPartyService.getThirdPartyExchangeRates(
        cryptos, // TBC
        currencies,
        channel.getChannelUrl(),
        channelTran.getDomainVersion(),
        channelTran.getDomainUrl());

    return channelDto;
  }

}
