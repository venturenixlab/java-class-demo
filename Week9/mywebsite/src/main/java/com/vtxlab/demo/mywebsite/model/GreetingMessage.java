package com.vtxlab.demo.mywebsite.model;

public class GreetingMessage {
  private String message;

  public GreetingMessage(String name) {
    this.message = String.format("Hello %s!", name);
  }

  public String getMessage() {
    return message;
  }
}