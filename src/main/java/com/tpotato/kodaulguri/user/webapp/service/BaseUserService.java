package com.tpotato.kodaulguri.user.webapp.service;

import com.tpotato.kodaulguri.user.webapp.dao.PaymentDao;
import com.tpotato.kodaulguri.user.webapp.domain.dto.UserReceipt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class BaseUserService {
  private final PaymentDao paymentDao;

  public Mono<UserReceipt> getUserReceipt(long userId) {
    return paymentDao.getUserReceipt(userId);
  }
}
