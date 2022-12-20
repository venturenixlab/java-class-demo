package com.vtxlab.crypto.admin.service;

import com.vtxlab.crypto.admin.entity.ChannelCoinMapping;

public interface CoinMappingService {

  ChannelCoinMapping save(Long id, ChannelCoinMapping channelCoinMapping);

}
