package com.tpotato.kodaulguri.user.webapp.service;

import com.tpotato.kodaulguri.user.webapp.dao.PaymentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class BaseUserService {
  private final PaymentDao paymentDao;

  public Mono<String> getUserPaymentInfo(long userId) {
    return paymentDao.getUserPaymentInfo(userId);
  }
}
