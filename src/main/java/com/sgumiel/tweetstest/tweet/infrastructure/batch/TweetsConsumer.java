package com.sgumiel.tweetstest.tweet.infrastructure.batch;

import java.io.IOException;
import java.util.List;

import com.sgumiel.tweetstest.flag.TwitterSignedInFlag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Slf4j
@Service
public class TweetsConsumer {

  @Autowired
  private TwitterSignedInFlag twitterSignedInFlag;

  @Scheduled(fixedDelay = 10000)
  public void readTweets() throws TwitterException, IOException {

    log.debug("Read tweets");

    if(!twitterSignedInFlag.isSignedIn()){
      return;
    }

    Twitter twitter = TwitterFactory.getSingleton();

    Paging p = new Paging(1 , 50);
    List<Status> statuses = twitter.getHomeTimeline(p);
    System.out.println("Showing home timeline.");
    for (Status status : statuses) {
      System.out.println(status.getUser().getName() + ":" +
              status.getText());
    }
  }

}