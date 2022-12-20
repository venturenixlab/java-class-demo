package com.vtxlab.crypto.admin.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.crypto.admin.controller.ChannelOperations;
import com.vtxlab.crypto.admin.entity.Channel;
import com.vtxlab.crypto.admin.service.ChannelService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/crypto/admin/api/v1")
@Slf4j
public class ChannelController implements ChannelOperations {

  @Autowired
  ChannelService channelService;

  @Override
  public Channel getChannel(String sourceApp, String tranType) {
    return channelService.getChannel(sourceApp, tranType);
  }

  @Override
  public List<Channel> getAllChannel() {
    return channelService.getAllChannel();
  }

  @Override
  public Channel saveChannel(Channel channel) {
    log.info("channel={}", channel);
    return channelService.saveChannel(channel);
  }

  @Override
  public Channel updateChannel(Channel channel, Long id) {
    return channelService.updateChannel(channel, id);
  }

  @Override
  public Channel submitChannel(Channel channel) {
    return channelService.submitChannel(channel);
  }

  @Override
  public void deleteAllChannel() {
    channelService.deleteAllChannel();
  }
}
