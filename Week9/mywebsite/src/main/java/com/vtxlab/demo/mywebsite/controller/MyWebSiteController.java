package com.vtxlab.demo.mywebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtxlab.demo.mywebsite.model.GreetingMessage;

@Controller
// @ResponseBody
// @RestController
public class MyWebSiteController {

  @GetMapping("/greeting")
  public String greeting(
      @RequestParam(name = "name", required = false, defaultValue = "World") String name,
      Model model) {

    model.addAttribute("name", name);
    return "greetings";
  }

  @GetMapping("/rest-greeting")
  @ResponseBody
  public GreetingMessage getGreetingMessage(
      @RequestParam(name = "name", required = false, defaultValue = "World") String name) {
    return new GreetingMessage(name);
  }
}
