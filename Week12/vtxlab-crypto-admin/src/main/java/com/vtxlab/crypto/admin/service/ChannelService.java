package com.vtxlab.crypto.admin.service;

import com.vtxlab.crypto.admin.entity.Channel;

public interface ChannelService {

  Channel getChannel(String sourceType, String tranType);

}
