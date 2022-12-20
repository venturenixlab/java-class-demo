package com.vtxlab.crypto.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtxlab.crypto.admin.entity.ChannelCoinMapping;

@Repository
public interface CoinMappingRepository
    extends JpaRepository<ChannelCoinMapping, Long> {

}
