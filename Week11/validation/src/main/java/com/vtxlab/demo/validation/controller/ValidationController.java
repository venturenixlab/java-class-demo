package com.vtxlab.demo.validation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.validation.model.Payment;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1")
public class ValidationController {

  @PostMapping(value = "/payment")
  public ResponseEntity<Payment> savePayment(@Valid @RequestBody Payment payment) {
    log.info("start controller");
    return ResponseEntity.ok().body(payment);
  }

}
