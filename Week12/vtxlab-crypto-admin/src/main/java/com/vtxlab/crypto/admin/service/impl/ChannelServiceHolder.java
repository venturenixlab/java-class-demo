package com.vtxlab.crypto.admin.service.impl;

import javax.swing.event.ChangeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
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
        .findByCoinTransSourceAppAndCoinTransTranType(
            sourceType, tranType);
  }

  @Override
  public Boolean isChannelCodeExist(String channelCode) {
    return channelRepository.findByChannelCode(channelCode);
  }

  @Override
  public Channel saveChannel(Channel channel) {
    return channelRepository.save(channel);
  }

  @Override
  public Channel submitChannel(Channel channel) {
    if (!isChannelCodeExist(channel.getChannelCode())) {
      saveChannel(channel);
    }
    throw new IllegalArgumentException();
  }

  @Override
  public Channel updateChannel(Channel channel, Long id) {
    if (channelRepository.existsById(id)) {
      return channelRepository.save(channel);
    }
    return null;
  }
}
