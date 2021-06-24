package com.sgumiel.tweetstest.tweet.application;

import com.sgumiel.tweetstest.tweet.domain.User;

public interface UserService {

  User findById(Long id);

  User save(User user);
}
