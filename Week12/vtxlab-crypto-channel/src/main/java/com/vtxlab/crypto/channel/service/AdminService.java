package com.vtxlab.crypto.channel.service;

import java.util.List;

import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.Channel;
import com.vtxlab.crypto.channel.model.ChannelCoinMapping;

public interface AdminService {

  Channel getChannelBySourceAppAndTranType(String SourceApp, String tranType)
      throws ApiException;

  List<ChannelCoinMapping> getCoinMappings(Long id)
      throws ApiException;

  Channel getChannelByChannelCode(String channelCode)
      throws ApiException;

}
