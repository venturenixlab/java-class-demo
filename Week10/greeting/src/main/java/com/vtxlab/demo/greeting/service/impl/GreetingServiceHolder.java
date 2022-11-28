package com.vtxlab.demo.greeting.service.impl;

import org.springframework.stereotype.Service;

import com.vtxlab.demo.greeting.service.GreetingService;

@Service // During start up, create bean to spring context
public class GreetingServiceHolder implements GreetingService {

  @Override
  public String greeting() {
    return "abc";
  }

}
