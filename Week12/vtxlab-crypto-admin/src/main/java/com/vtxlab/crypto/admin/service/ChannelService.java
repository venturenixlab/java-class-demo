package com.vtxlab.crypto.admin.service;

import java.util.List;

import com.vtxlab.crypto.admin.entity.Channel;

public interface ChannelService {

  Channel getChannel(String sourceType, String tranType);

  List<Channel> getAllChannel();

  Channel saveChannel(Channel channel);

  Channel updateChannel(Channel channel, Long id);

  Boolean isChannelCodeExist(String channelCode);

  Channel submitChannel(Channel channel);

  void deleteAllChannel();

}
