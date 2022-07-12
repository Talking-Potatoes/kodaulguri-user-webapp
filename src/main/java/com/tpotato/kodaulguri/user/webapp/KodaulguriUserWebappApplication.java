package com.tpotato.kodaulguri.user.webapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableEurekaClient
@EnableBinding({Sink.class, Source.class})
@EnableCaching
public class KodaulguriUserWebappApplication {

  public static void main(String[] args) {
    SpringApplication.run(KodaulguriUserWebappApplication.class, args);
  }

}
