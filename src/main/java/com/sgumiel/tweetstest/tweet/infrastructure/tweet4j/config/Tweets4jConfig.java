package com.sgumiel.tweetstest.tweet.infrastructure.tweet4j.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Data
@Configuration
@EnableScheduling
@ConfigurationProperties(prefix = "tweeter.credentials")
public class Tweets4jConfig {

  private String apiKey;
  private String apiSecret;

  private String secret;
  private String tokenSecret;
}
