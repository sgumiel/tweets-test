package com.sgumiel.tweetstest.tweet.infrastructure.rest.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class HashtagResponse implements Serializable {

  private static final long serialVersionUID = 8669298583959497253L;

  private Long id;
  private String tag;
  private Integer occurrences;
}
