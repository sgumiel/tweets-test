package com.sgumiel.tweetstest.tweet.infrastructure.batch;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Data
@Configuration
@EnableScheduling
@ConfigurationProperties(prefix = "tweeter.credentials")
public class TweetsConsumerConfig {

  private String apiKey;
  private String apiSecret;

  private String secret;
  private String tokenSecret;
}
