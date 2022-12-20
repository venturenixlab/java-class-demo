package com.vtxlab.crypto.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.crypto.admin.entity.ChannelTransaction;
import com.vtxlab.crypto.admin.repository.ChannelRepository;
import com.vtxlab.crypto.admin.repository.TransactionRepository;
import com.vtxlab.crypto.admin.service.TransactionService;

@Service
public class TransactionServiceHolder implements TransactionService {

  @Autowired
  TransactionRepository transactionRepository;

  @Autowired
  ChannelRepository channelRepository;

  @Override
  public ChannelTransaction save(Long id,
      ChannelTransaction transaction) {
        
    return channelRepository.findById(id).map(channel -> {
      transaction.setChannel(channel);
      return transactionRepository.save(transaction);
    }).orElse(null);
    // return transactionRepository.save(transaction);
  }
}
