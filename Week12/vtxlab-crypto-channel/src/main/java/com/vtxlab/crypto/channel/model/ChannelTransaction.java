package com.vtxlab.crypto.channel.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChannelTransaction {

  private Long id;

  private String domainVersion;

  private String domainUrl;

  private String sourceApp;

  private String tranType;

  private LocalDateTime lastUpdDate;

  private Channel channel;

}
