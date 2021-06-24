package com.sgumiel.tweetstest.tweet.domain.repository;

import java.util.Optional;

import com.sgumiel.tweetstest.tweet.domain.User;

public interface UserRepository {

  Optional<User> findById(Long id);

  User saveIfNotExist(User user);
}
