package com.sgumiel.tweetstest.tweet.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TweetFilter {

  private Boolean validated;
  private Long userId;


}
