package com.vtxlab.crypto.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtxlab.crypto.admin.entity.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

  /*
   * select *
   * FROM CHANNELS c, CHANNEL_TRANS t, CHANNEL_COIN_MAPPINGS M
   * where c.id = t.channel_id
   * and c.id = m.channel_id
   * and t.source_app = 'crypto-web'
   * and t.tran_type = 'ex-rate';
   */
  Channel findByCoinTransSourceAppAndCoinTransTranType(
      String sourceApp,
      String tranType);

  Channel findByChannelCode(String ChannelCode);

  Boolean existsByChannelCode(String ChannelCode);

}
