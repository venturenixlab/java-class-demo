package com.vtxlab.crypto.admin.service;

import com.vtxlab.crypto.admin.entity.ChannelTransaction;

public interface TransactionService {

  ChannelTransaction save(Long id, ChannelTransaction channelTransaction);

}
