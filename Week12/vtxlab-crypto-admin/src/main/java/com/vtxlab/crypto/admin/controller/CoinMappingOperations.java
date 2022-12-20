package com.vtxlab.crypto.admin.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.crypto.admin.entity.ChannelCoinMapping;

@RequestMapping(value = "default")
public interface CoinMappingOperations {

  @PostMapping(value = "/channel/{id}/coinmap")
  ChannelCoinMapping saveCoinMapping(
      @PathVariable Long id,
      @RequestBody ChannelCoinMapping coinMapping);
}
