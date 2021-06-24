package com.sgumiel.tweetstest.tweet.infrastructure.tweet4j;

import java.io.IOException;

import twitter4j.TwitterException;

public interface TweetsLoader {

  void loadTweets() throws TwitterException, IOException;
}
