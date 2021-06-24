package com.sgumiel.tweetstest.tweet.application;

import com.sgumiel.tweetstest.tweet.domain.TweetAggregate;

public interface CheckTweetService {

  Boolean check(TweetAggregate tweetAggregate);
}
