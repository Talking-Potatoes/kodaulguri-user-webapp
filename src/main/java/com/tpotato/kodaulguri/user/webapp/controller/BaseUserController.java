package com.tpotato.kodaulguri.user.webapp.controller;

import com.tpotato.kodaulguri.user.webapp.domain.dto.User;
import com.tpotato.kodaulguri.user.webapp.domain.dto.UserReceipt;
import com.tpotato.kodaulguri.user.webapp.service.BaseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/user")
public class BaseUserController {
  private final BaseUserService userService;

  @RequestMapping(path = "/receipt", method = RequestMethod.GET)
  public Mono<UserReceipt> getReceipt(@RequestParam("userId")long userId) {
    return userService.getUserReceipt(userId);
  }

}
