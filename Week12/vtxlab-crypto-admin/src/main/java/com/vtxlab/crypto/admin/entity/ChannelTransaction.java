package com.vtxlab.crypto.admin.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CHANNEL_TRANS")
public class ChannelTransaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Nonnull
  @Column(name = "DOMAIN_VERSION")
  private String domainVersion;

  @Nonnull
  @Column(name = "DOMAIN_URL")
  private String domainUrl;

  @Nonnull
  @Column(name = "SOURCE_APP")
  private String sourceApp;

  @Nonnull
  @Column(name = "TRAN_TYPE")
  private String tranType;

  @Nonnull
  @Column(name = "LAST_UPD_DATE")
  private LocalDateTime lastUpdDate;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "CHANNEL_ID", referencedColumnName = "ID")
  @JsonIgnoreProperties("coinTrans")
  private Channel channel;

}
