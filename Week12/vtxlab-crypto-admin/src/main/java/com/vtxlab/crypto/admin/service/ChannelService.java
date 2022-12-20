package com.vtxlab.crypto.admin.service;

import com.vtxlab.crypto.admin.entity.Channel;

public interface ChannelService {

  Channel getChannel(String sourceType, String tranType);

  Channel saveChannel(Channel channel);

  Channel updateChannel(Channel channel, Long id);

  Boolean isChannelCodeExist(String channelCode);

  Channel submitChannel(Channel channel);

}
