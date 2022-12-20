package com.vtxlab.crypto.admin.service;

import java.util.List;
import java.util.UUID;

import com.vtxlab.crypto.admin.entity.Channel;

public interface ChannelService {

  Channel getChannel(String sourceType, String tranType);

  List<Channel> getAllChannel();

  Channel saveChannel(Channel channel, UUID uuid);

  Channel updateChannel(Channel channel, Long id);

  Boolean isChannelCodeExist(String channelCode);

  Channel submitChannel(Channel channel, UUID uuid);

  void deleteAllChannel();

}
