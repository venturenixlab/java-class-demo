package com.vtxlab.crypto.channel.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.Channel;
import com.vtxlab.crypto.channel.service.AdminService;
import com.vtxlab.crypto.channel.utils.ChannelApi;

@Service
public class AdminServiceHolder implements AdminService {

  @Autowired
  ChannelApi channelApi;

  @Value("${service.admin.baseUrl}")
  String baseUrl;

  @Value("${service.admin.serviceVers}")
  String serviceVers;

  @Value("${service.admin.serviceUrl}")
  String serviceUrl;

  @Override
  public Channel getChannelBySourceAppAndTranType(String sourceApp,
      String tranType) throws ApiException {
    // Invoke vtxlab-crypto-admin API
    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("sourceApp", sourceApp);
    hMap.put("tranType", tranType);

    return channelApi.invoke(baseUrl,
        serviceVers, serviceUrl,
        hMap, Channel.class);
  }
}
