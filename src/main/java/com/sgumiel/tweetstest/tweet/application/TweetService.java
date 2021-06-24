package com.sgumiel.tweetstest.tweet.application;

import java.util.List;

import com.sgumiel.tweetstest.tweet.domain.Tweet;
import com.sgumiel.tweetstest.tweet.domain.TweetAggregate;
import com.sgumiel.tweetstest.tweet.domain.TweetFilter;

public interface TweetService {

  List<Tweet> findAll();

  TweetAggregate save(TweetAggregate tweetAggregate);

  void validate(Long id);

  List<Tweet> findByFilter(TweetFilter tweetFilter);
}
