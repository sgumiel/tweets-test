package com.sgumiel.tweetstest.tweet.infrastructure.tweet4j;

import java.io.IOException;
import java.util.List;

import com.sgumiel.tweetstest.flag.TwitterSignedInFlag;
import com.sgumiel.tweetstest.tweet.application.TweetService;
import com.sgumiel.tweetstest.tweet.infrastructure.tweet4j.map.Tweet4jMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Slf4j
@Service
public class TweetsLoaderImpl implements TweetsLoader{

  @Autowired
  private TwitterSignedInFlag twitterSignedInFlag;

  @Autowired
  private TweetService tweetService;

  @Autowired
  private Tweet4jMapper tweetRefactorMapper;

  @Override
  public void loadTweets() throws TwitterException, IOException {

    log.debug("Read tweets");

    if(!twitterSignedInFlag.isSignedIn()){
      return;
    }

    Twitter twitter = TwitterFactory.getSingleton();

    Paging p = new Paging(1 , 50);
    List<Status> statuses = twitter.getHomeTimeline(p);

    statuses.stream().forEach( status -> {

      final var tweetAggregate = this.tweetRefactorMapper.toDomain(status);

      final var tweetSaved = this.tweetService.save(tweetAggregate);

    });
//    System.out.println("Showing home timeline.");
//    for (Status status : statuses) {
//      System.out.println(status.getUser().getName() + ":" +
//              status.getText());
//    }
  }

}