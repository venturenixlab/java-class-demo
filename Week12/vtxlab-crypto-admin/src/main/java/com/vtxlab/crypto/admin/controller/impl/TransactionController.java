package com.vtxlab.crypto.admin.controller.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.crypto.admin.controller.TransactionOperations;
import com.vtxlab.crypto.admin.entity.ChannelTransaction;
import com.vtxlab.crypto.admin.service.TransactionService;

@RestController
@RequestMapping(value = "/crypto/admin/api/v1")
public class TransactionController implements TransactionOperations {
  @Autowired
  TransactionService transactionService;

  @Override
  public ChannelTransaction saveTransaction(Long id,
      ChannelTransaction coinMapping) {
    return transactionService.save(id, coinMapping);
  }

}
