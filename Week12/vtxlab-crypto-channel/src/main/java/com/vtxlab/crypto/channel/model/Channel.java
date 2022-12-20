package com.vtxlab.crypto.channel.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Channel implements Serializable {

  private Long id;

  private String channelCode;

  private String channelUrl;

  private LocalDateTime lastUpdDate;

  private List<ChannelCoinMapping> coinMaps = new ArrayList<>();

  private List<ChannelTransaction> coinTrans = new ArrayList<>();

}
