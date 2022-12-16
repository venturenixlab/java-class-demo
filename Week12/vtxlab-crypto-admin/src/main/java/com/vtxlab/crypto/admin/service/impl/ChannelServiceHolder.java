package com.vtxlab.crypto.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.crypto.admin.entity.Channel;
import com.vtxlab.crypto.admin.repository.ChannelRepository;
import com.vtxlab.crypto.admin.service.ChannelService;

@Service
public class ChannelServiceHolder implements ChannelService {

  @Autowired
  ChannelRepository channelRepository;

  @Override
  public Channel getChannel(String sourceType, String tranType) {
    return channelRepository
        .findByChannelTransactionsSourceAppAndChannelTransactionsTranType(
            sourceType, tranType);
  }
}
