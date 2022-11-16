package com.vtxlab.demo.helloworld2.service;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class WhatsappService {
  // SID
  // SK2c6ca502e4bc69afab6eb255d142843c

  // Find your Account Sid and Token at twilio.com/console
  public static final String ACCOUNT_SID = "AC44d08bb0034eeeb52fb8897ded40d01e";
  public static final String AUTH_TOKEN = "6e07a0d20a0ffb2d1b3aba21d3920549";

  // vincent-twilio-api-key

  public String sendMessage() {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    return Message.creator(
        new com.twilio.type.PhoneNumber("whatsapp:+19452073165"),
        new com.twilio.type.PhoneNumber("whatsapp:+85290122193"),
        "Your appointment is coming up on July 21 at 3PM")
        .create()//
        .getSid();
  }

}
