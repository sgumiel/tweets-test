package com.sgumiel.tweetstest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sgumiel.tweetstest.flag.TwitterSignedInFlag;
import com.sgumiel.tweetstest.tweet.infrastructure.batch.TweetsConsumerConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Slf4j
@Service
public class TwitterSignInService {

  @Autowired
  private TweetsConsumerConfig tweetsConsumerConfig;

  @Autowired
  private TwitterSignedInFlag twitterSignedInFlag;

  public void signIn() throws TwitterException, IOException {

    Twitter twitter = TwitterFactory.getSingleton();

    if(StringUtils.isNotEmpty(tweetsConsumerConfig.getSecret()) && StringUtils.isNotEmpty(tweetsConsumerConfig.getTokenSecret())) {
      final var accessToken = new AccessToken(tweetsConsumerConfig.getSecret(), tweetsConsumerConfig.getTokenSecret());
      twitter.setOAuthConsumer(tweetsConsumerConfig.getApiKey(), tweetsConsumerConfig.getApiSecret());
      twitter.setOAuthAccessToken(accessToken);
      twitterSignedInFlag.signedIn();
      log.debug("Signed in");
      return;

    }

    twitter.setOAuthConsumer(tweetsConsumerConfig.getApiKey(), tweetsConsumerConfig.getApiSecret());
    RequestToken requestToken = twitter.getOAuthRequestToken();
    AccessToken accessToken = null;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (null == accessToken) {
      System.out.println("Open the following URL and grant access to your account:");
      System.out.println(requestToken.getAuthorizationURL());
      System.out.print("Enter the PIN(if available) or just hit enter.[PIN]:");
      String pin = br.readLine();
      try {
        if (pin.length() > 0) {
          accessToken = twitter.getOAuthAccessToken(requestToken, pin);
        } else {
          accessToken = twitter.getOAuthAccessToken();
        }
      } catch (TwitterException te) {
        if (401 == te.getStatusCode()) {
          System.out.println("Unable to get the access token.");
        } else {
          te.printStackTrace();
        }
      }
    }
    log.debug("Signed in");
    twitterSignedInFlag.signedIn();
  }
}
