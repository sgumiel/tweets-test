package com.sgumiel.tweetstest.tweet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hashtag {

  private Long id;
  private String tag;
  private Integer occurrences;
}
