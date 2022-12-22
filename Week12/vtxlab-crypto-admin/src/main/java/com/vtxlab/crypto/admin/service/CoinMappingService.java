package com.vtxlab.crypto.admin.service;

import java.util.List;

import com.vtxlab.crypto.admin.entity.ChannelCoinMapping;

public interface CoinMappingService {

  ChannelCoinMapping save(Long id, ChannelCoinMapping channelCoinMapping);

  List<ChannelCoinMapping> getByChannelId(Long id);

}
