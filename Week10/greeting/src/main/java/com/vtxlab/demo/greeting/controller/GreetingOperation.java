package com.vtxlab.demo.greeting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/default")
public interface GreetingOperation {

  @GetMapping(value = "/greeting")
  String greeting();
}
