package com.vtxlab.crypto.admin.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.vtxlab.crypto.admin.entity.Channel;
import com.vtxlab.crypto.admin.repository.ChannelRepository;
import com.vtxlab.crypto.admin.service.ChannelService;

@Service
public class ChannelServiceHolder implements ChannelService {

  @Autowired
  ChannelRepository channelRepository;

  @Autowired
  RedisTemplate<String, Channel> redisTemplate;

  @Override
  public Channel getChannel(String sourceType, String tranType) {
    return channelRepository
        .findByCoinTransSourceAppAndCoinTransTranType(
            sourceType, tranType);
  }

  @Override
  public Channel getChannel(String channelCode) {
    return channelRepository.findByChannelCode(channelCode);
  }

  @Override
  public List<Channel> getAllChannel() {
    return channelRepository.findAll();
  }

  @Override
  public Boolean isChannelCodeExist(String channelCode) {
    return channelRepository.existsByChannelCode(channelCode);
  }

  @Override
  public Channel saveChannel(Channel channel, UUID uuid) {
    String redisKey = "crypto:admin:post:channel:uuid:" + uuid;
    // crypto:admin:post:channel:uuid:f79113af-c7c6-4427-af14-7a34098851a9
    if (redisTemplate.opsForValue().get(redisKey) != null) {
      return null;
    }
    Channel savedChannel = channelRepository.save(channel);
    redisTemplate.opsForValue().set(redisKey, savedChannel, Duration.ofDays(1));
    return savedChannel;
  }

  @Override
  public Channel submitChannel(Channel channel, UUID uuid) {
    if (!isChannelCodeExist(channel.getChannelCode())) {
      saveChannel(channel, uuid);
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
