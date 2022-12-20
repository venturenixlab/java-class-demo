package com.vtxlab.crypto.channel.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChannelCoinMapping {

  private Long id;

  private String coinCode;

  private String coinId;

  private LocalDateTime lastUpdDate;

  private Channel channel;

}
