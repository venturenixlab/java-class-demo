package com.vtxlab.crypto.admin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.crypto.admin.entity.Channel;

import jakarta.validation.Valid;

@RequestMapping(value = "/default")
public interface ChannelOperations {

  @GetMapping(value = "/channel")
  Channel getChannel(@RequestParam String sourceApp,
      @RequestParam String tranType);

  @GetMapping(value = "/channels")
  List<Channel> getAllChannel();

  @PostMapping(value = "/channel")
  Channel saveChannel(@Valid @RequestBody Channel channel);

  @PutMapping(value = "/channel/{id}")
  Channel updateChannel(@Valid @RequestBody Channel channel,
      @PathVariable Long id);

  @PostMapping(value = "/channel-submit")
  Channel submitChannel(@Valid @RequestBody Channel channel);

  @DeleteMapping(value = "/channels")
  void deleteAllChannel();
}
