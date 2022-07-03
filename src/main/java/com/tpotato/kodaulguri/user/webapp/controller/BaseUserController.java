package com.tpotato.kodaulguri.user.webapp.controller;

import com.tpotato.kodaulguri.user.webapp.domain.dto.User;
import com.tpotato.kodaulguri.user.webapp.service.BaseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/user")
public class BaseUserController {
  private final BaseUserService userService;
  private final Source source;

  @RequestMapping(path = "/send", method = RequestMethod.GET)
  public void sendUser() {
    //TODO : 비지니스 로직도 하고
    source.output()
        .send(MessageBuilder.withPayload(
            User.builder().id(1L).age(30).gender('M').name("jhpark").build())
            .build());
  }

  @RequestMapping(path = "/paymentInfo", method = RequestMethod.GET)
  public Mono<String> paymentInfo() {
    return userService.getUserPaymentInfo(1L);
  }

}
