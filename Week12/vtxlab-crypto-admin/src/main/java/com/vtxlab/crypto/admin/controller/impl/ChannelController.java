package com.vtxlab.crypto.admin.controller.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.crypto.admin.controller.ChannelOperations;
import com.vtxlab.crypto.admin.entity.Channel;
import com.vtxlab.crypto.admin.service.ChannelService;

@RestController
@RequestMapping(value = "/crypto/admin/api/v1")
public class ChannelController implements ChannelOperations {

  @Autowired
  ChannelService channelService;

  @Override
  public Channel getChannel(String sourceApp, String tranType) {
    return channelService.getChannel(sourceApp, tranType);
  }

  @Override
  public Channel getChannel(String channelCode) {
    return channelService.getChannel(channelCode);
  }

  @Override
  public List<Channel> getAllChannel() {
    return channelService.getAllChannel();
  }

  @Override
  public ResponseEntity<Channel> saveChannel(Channel channel, UUID uuid) {
    Channel savedChannel = channelService.saveChannel(channel, uuid);
    if (savedChannel == null) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().body(savedChannel);
  }

  @Override
  public Channel updateChannel(Channel channel, Long id) {
    return channelService.updateChannel(channel, id);
  }

  @Override
  public Channel submitChannel(Channel channel, UUID uuid) {
    return channelService.submitChannel(channel, uuid);
  }

  @Override
  public void deleteAllChannel() {
    channelService.deleteAllChannel();
  }
}
