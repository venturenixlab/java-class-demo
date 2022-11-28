package com.vtxlab.demo.greeting.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.greeting.controller.GreetingOperation;
import com.vtxlab.demo.greeting.service.GreetingService;

import lombok.AllArgsConstructor;

@RestController // During start up, create bean to spring context
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
public class GreetingController implements GreetingOperation {

  @Autowired
  GreetingService greetingService;

  @Override
  public String greeting() {
    // 9999 ...
    return greetingService.greeting() + "d"; // mock
  }

}
