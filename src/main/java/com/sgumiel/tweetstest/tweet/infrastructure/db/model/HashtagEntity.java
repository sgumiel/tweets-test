package com.sgumiel.tweetstest.tweet.infrastructure.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hashtag")
public class HashtagEntity implements Serializable {

  private static final long serialVersionUID = 4540463068378765659L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String tag;
  private Integer occurrences;
}
