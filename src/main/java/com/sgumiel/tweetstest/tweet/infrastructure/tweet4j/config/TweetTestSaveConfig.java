package com.sgumiel.tweetstest.tweet.infrastructure.tweet4j.config;

import java.util.List;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "tweettest.save")
public class TweetTestSaveConfig {

  private Integer minFollowersToSave;
  private List<String> langs;
}
