package com.vtxlab.crypto.channel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.Channel;
import com.vtxlab.crypto.channel.model.ChannelCoinMapping;
import com.vtxlab.crypto.channel.model.ChannelTransaction;
import com.vtxlab.crypto.channel.model.dto.ChannelDto;
import com.vtxlab.crypto.channel.service.AdminService;
import com.vtxlab.crypto.channel.service.OrchestrationService;
import com.vtxlab.crypto.channel.service.ThirdPartyService;
import com.vtxlab.crypto.channel.service.ThirdPartyService2;
import com.vtxlab.crypto.channel.utils.ThirdPartyServiceFactory;

@Service
public class OrchestrationServiceHolder implements OrchestrationService {

    @Autowired
    AdminService adminService;

    @Autowired
    ThirdPartyService thirdPartyService;

    @Autowired
    ThirdPartyServiceFactory thirdPartyServiceFactory;

    final static String TRAN_TYPE_EX_RATE = "ex-rate";

    // Design Appraoch 1: When we have admin-service
    @Override
    public ChannelDto getExchangeRates(List<String> cryptos,
            List<String> currencies, String sourceApp) throws ApiException {
        // Step 1: Invoke Admin Service
        Channel channel = adminService.getChannelBySourceAppAndTranType(
                sourceApp,
                TRAN_TYPE_EX_RATE);

        // Step 2: Prepare parameters and get channel Transactions
        Predicate<ChannelTransaction> sourceAppCheck = e -> sourceApp
                .equals(e.getSourceApp());
        Predicate<ChannelTransaction> tranTypeCheck = e -> TRAN_TYPE_EX_RATE
                .equals(e.getTranType());

        // Get Channel Transaction for URL mapping
        ChannelTransaction channelTran = channel.getCoinTrans().stream()
                .filter(sourceAppCheck.and(tranTypeCheck)).findFirst()
                .orElse(null);

        // Step 3: Get Channel Coin Mapping for coin code conversion
        List<String> coinIds = channel.getCoinMaps().stream()
                .map(e -> e.getCoinId()).collect(Collectors.toList());

        // Step 4: Invoke Third Party API Service
        return thirdPartyService.getThirdPartyExchangeRates(
                coinIds, // [bitcoin,tether,ethereum]
                currencies,
                channel.getChannelUrl(),
                channelTran.getDomainVersion(),
                channelTran.getDomainUrl());
    }

    // Design Approach 2: Assume all third API service mapping coded in
    // channel-service
    @Override
    public ChannelDto getExchangeRates2(List<String> cryptos,
            List<String> currencies, String sourceApp) throws ApiException {

        ThirdPartyService2 thirdPartyService = thirdPartyServiceFactory
                .produceThirdPartyService(sourceApp);

        return thirdPartyService.getThirdPartyExchangeRates(cryptos,
                currencies);
    }

}
