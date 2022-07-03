package com.tpotato.kodaulguri.user.webapp.dao;


import com.tpotato.kodaulguri.user.webapp.component.ReactorCacheable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Repository
public class PaymentDao {
  private final WebClient.Builder webClientBuilder;

  @Value("${kodaulguri.payment.url}")
  private String paymentUrl;

  @ReactorCacheable(name = "getUserPaymentInfo")
  public Mono<String> getUserPaymentInfo(long userId) {
    WebClient webClient = webClientBuilder.baseUrl("http://" + paymentUrl).build();
    return webClient.get()
        .uri(uriBuilder -> uriBuilder.path("/pay/v1/base").build())
        .retrieve()
        .bodyToMono(String.class);
  }


}
