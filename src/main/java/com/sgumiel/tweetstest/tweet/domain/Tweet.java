package com.sgumiel.tweetstest.tweet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {

  private Long id;
  private Long userId;
  private String text;
  private String lang;
  private Double longitude;
  private Double latitude;
  private Boolean validated;
}
