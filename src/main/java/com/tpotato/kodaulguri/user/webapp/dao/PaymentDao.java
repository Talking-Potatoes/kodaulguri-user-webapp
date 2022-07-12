package com.tpotato.kodaulguri.user.webapp.dao;


import com.tpotato.kodaulguri.user.webapp.component.ReactiveCacheManager;
import com.tpotato.kodaulguri.user.webapp.component.ReactorCacheable;
import com.tpotato.kodaulguri.user.webapp.domain.dto.UserReceipt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Repository
public class PaymentDao {
  private final WebClient.Builder webClientBuilder;
  private final ReactiveCacheManager reactiveCacheManager;

  @Value("${kodaulguri.payment.url}")
  private String paymentUrl;

  @ReactorCacheable(name = "userReceipt")
  public Mono<UserReceipt> getUserReceipt(long userId) {
    WebClient webClient = webClientBuilder.baseUrl("http://" + paymentUrl).build();
    return webClient.get()
        .uri(uriBuilder -> uriBuilder.path("/pay/v1/receipt")
                                      .queryParam("userId", userId).build())
        .retrieve()
        .bodyToMono(UserReceipt.class);
  }


  @StreamListener(value = Sink.INPUT)
  private void listeningPaymentEvent(UserReceipt receipt) {
    log.info("Received UserReceipt : {}", receipt);
    updateUserReceipt(receipt.getUserId(), receipt);
  }

  public void updateUserReceipt(long userId, UserReceipt receipt) {
    reactiveCacheManager.updateCache("userReceipt", userId, receipt);
  }


}
