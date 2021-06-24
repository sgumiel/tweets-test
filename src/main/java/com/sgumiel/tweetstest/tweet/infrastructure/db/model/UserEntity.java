package com.sgumiel.tweetstest.tweet.infrastructure.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

  private static final long serialVersionUID = 1366057248355235922L;

  @Id
  private Long id;

  private String name;

  private Long followers;
}
