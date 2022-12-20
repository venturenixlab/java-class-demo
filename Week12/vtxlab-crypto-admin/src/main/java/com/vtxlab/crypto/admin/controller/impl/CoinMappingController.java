package com.vtxlab.crypto.admin.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.crypto.admin.controller.CoinMappingOperations;
import com.vtxlab.crypto.admin.entity.ChannelCoinMapping;
import com.vtxlab.crypto.admin.service.CoinMappingService;

@RestController
@RequestMapping(value = "/crypto/admin/api/v1")
public class CoinMappingController implements CoinMappingOperations {

  @Autowired
  CoinMappingService coinMappingService;

  @Override
  public ChannelCoinMapping saveCoinMapping(Long id,
      ChannelCoinMapping coinMapping) {
    return coinMappingService.save(id, coinMapping);
  }

}
