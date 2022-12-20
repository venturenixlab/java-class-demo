package com.vtxlab.crypto.admin.service.impl;

import java.time.LocalDateTime;
import java.util.List;

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
        .findByCoinTransSourceAppAndCoinTransTranType(
            sourceType, tranType);
  }

  @Override
  public List<Channel> getAllChannel() {
    return channelRepository.findAll();
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
    return channelRepository.findById(id).map(chl -> {
      chl.setChannelCode(channel.getChannelCode());
      chl.setChannelUrl(channel.getChannelUrl());
      chl.setLastUpdDate(channel.getLastUpdDate() == null ? LocalDateTime.now()
          : channel.getLastUpdDate());
      return channelRepository.save(chl);
    }).orElse(null);
    /*
     * if (channelRepository.existsById(id)) {
     * return channelRepository.save(channel);
     * }
     * return null;
     */
  }

  @Override
  public void deleteAllChannel() {
    channelRepository.deleteAll();
  }
}
