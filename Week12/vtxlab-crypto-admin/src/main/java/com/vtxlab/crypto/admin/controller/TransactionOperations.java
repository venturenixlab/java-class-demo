package com.vtxlab.crypto.admin.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.crypto.admin.entity.ChannelTransaction;

import jakarta.validation.Valid;

@RequestMapping(value = "/default")
public interface TransactionOperations {

  @PostMapping(value = "/channel/{id}/tran")
  ChannelTransaction saveTransaction(
      @PathVariable Long id,
      @Valid @RequestBody ChannelTransaction coinMapping);

}
