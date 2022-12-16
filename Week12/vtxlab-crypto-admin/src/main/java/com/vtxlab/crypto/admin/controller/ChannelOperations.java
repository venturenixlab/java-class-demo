package com.vtxlab.crypto.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.crypto.admin.entity.Channel;

@RequestMapping(value = "/default")
public interface ChannelOperations {

  @GetMapping(value = "/coin-mapping")
  Channel getChannel(@RequestParam String sourceApp,
      @RequestParam String tranType);

}
