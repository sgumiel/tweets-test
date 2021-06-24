package com.sgumiel.tweetstest.tweet.infrastructure.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tweet")
public class TweetEntity implements Serializable {

  private static final long serialVersionUID = -1555128150191438625L;

  @Id
  private Long id;

  @Column(name = "user_id")
  private Long userId;

  private String text;
  private String lang;
  private Double longitude;
  private Double latitude;
  private Boolean validated;
}
