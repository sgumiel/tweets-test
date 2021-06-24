package com.sgumiel.tweetstest.tweet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TweetAggregate {

  private Long id;
  private User user;
  private String text;
  private String lang;
  private Location location;
  private Boolean validated;
}
