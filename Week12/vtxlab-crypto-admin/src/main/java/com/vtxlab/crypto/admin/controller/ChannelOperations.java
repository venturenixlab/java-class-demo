package com.vtxlab.crypto.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.crypto.admin.entity.Channel;

@RequestMapping(value = "/default")
public interface ChannelOperations {

  @GetMapping(value = "/channel")
  Channel getChannel(@RequestParam String sourceApp,
      @RequestParam String tranType);

  @PostMapping(value = "/channel")
  Channel saveChannel(@RequestBody Channel channel);

  @PutMapping(value = "/channel/{id}")
  Channel updateChannel(@RequestBody Channel channel, @RequestParam Long id);

  @PostMapping(value = "/channel-submit")
  Channel submitChannel(@RequestBody Channel channel);

}
