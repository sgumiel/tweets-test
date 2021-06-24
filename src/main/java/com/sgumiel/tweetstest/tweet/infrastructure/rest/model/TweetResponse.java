package com.sgumiel.tweetstest.tweet.infrastructure.rest.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class TweetResponse implements Serializable {

  private static final long serialVersionUID = -5722604838005250282L;

  private Long id;
  private Long userId;
  private String text;
  private String lang;
  private Double longitude;
  private Double latitude;
  private Boolean validated;
}
