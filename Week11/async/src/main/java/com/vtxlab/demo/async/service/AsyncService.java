package com.vtxlab.demo.async.service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsyncService {

  @Async
  public void asyncService1() throws InterruptedException {
    log.info("asyncService1 start .... {}", LocalDateTime.now().toString());
    TimeUnit.SECONDS.sleep(5);
    log.info("asyncService1 completed .... {}", LocalDateTime.now().toString());
    // return "asyncService1 compelted.";
  }

  public void asyncService2() throws InterruptedException {
    log.info("asyncService2 start .... {}", LocalDateTime.now().toString());
    // TimeUnit.SECONDS.sleep(5);
    log.info("asyncService2 completed .... {}", LocalDateTime.now().toString());
    // return "asyncService2 compelted.";
  }
}
