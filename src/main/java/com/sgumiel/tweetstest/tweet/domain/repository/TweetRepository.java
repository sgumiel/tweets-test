package com.sgumiel.tweetstest.tweet.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sgumiel.tweetstest.tweet.domain.Tweet;
import com.sgumiel.tweetstest.tweet.domain.TweetFilter;

public interface TweetRepository {

  Tweet save(Tweet tweet);

  List<Tweet> findAll();

  Optional<Tweet> findById(Long id);

  List<Tweet> findByFilter(TweetFilter tweetFilter);

}