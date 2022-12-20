package com.vtxlab.crypto.admin.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.crypto.admin.entity.ChannelCoinMapping;
import com.vtxlab.crypto.admin.repository.ChannelRepository;
import com.vtxlab.crypto.admin.repository.CoinMappingRepository;
import com.vtxlab.crypto.admin.service.CoinMappingService;

@Service
public class CoinMappingServiceHolder implements CoinMappingService {

  @Autowired
  CoinMappingRepository coinMappingRepository;

  @Autowired
  ChannelRepository channelRepository;

  @Override
  public ChannelCoinMapping save(Long id,
      ChannelCoinMapping channelCoinMapping) {

    return channelRepository.findById(id).map(channel -> {
      channelCoinMapping.setChannel(channel);
      return coinMappingRepository.save(channelCoinMapping);
    }).orElse(null);
    /*
     * Channel channel = channelRepository.findById(id).orElse(null);
     * channelCoinMapping.setChannel(channel);
     * return coinMappingRepository.save(channelCoinMapping);
     */
  }

  public static List<Integer> convert(List<String> strings) {
    return strings.stream().map(str -> Integer.valueOf(str))
        .collect(Collectors.toList());
    /*
     * Integer integer = 0;
     * List<Integer> integers = new ArrayList<>();
     * for (String str : strings) {
     * integer = Integer.valueOf(str);
     * integers.add(integer);
     * }
     * return integers;
     */
  }

}
