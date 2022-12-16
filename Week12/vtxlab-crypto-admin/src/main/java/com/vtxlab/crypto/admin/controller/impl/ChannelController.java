package com.vtxlab.crypto.admin.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
}
