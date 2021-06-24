package com.sgumiel.tweetstest.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "tweettest.get")
public class TweetTestGetConfig {

  private Integer hashtag;
}
