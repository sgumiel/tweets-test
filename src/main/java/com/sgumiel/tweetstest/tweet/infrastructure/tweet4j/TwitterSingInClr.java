package com.sgumiel.tweetstest.tweet.infrastructure.tweet4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("local")
public class TwitterSingInClr implements CommandLineRunner {

  @Autowired
  private TwitterSignInService twitterSignInService;

  @Autowired
  private TweetsLoader tweetsLoader;

  @Override
  public void run(String... args) throws Exception {
    this.twitterSignInService.signIn();
    this.tweetsLoader.loadTweets();

  }
}
