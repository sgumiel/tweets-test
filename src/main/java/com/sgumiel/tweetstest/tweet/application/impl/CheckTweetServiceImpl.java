package com.sgumiel.tweetstest.tweet.application.impl;

import com.sgumiel.tweetstest.tweet.infrastructure.tweet4j.config.TweetTestSaveConfig;
import com.sgumiel.tweetstest.tweet.application.CheckTweetService;
import com.sgumiel.tweetstest.tweet.domain.TweetAggregate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckTweetServiceImpl implements CheckTweetService {

  private final TweetTestSaveConfig tweetTestConfig;

  @Override
  public Boolean check(TweetAggregate tweetAggregate) {

    log.debug("Check tweet save. Tweet: {}", tweetAggregate);

    final var minFollowers = tweetTestConfig.getMinFollowersToSave();
    log.debug("Min followers to save: {}", minFollowers);

    final var followers = tweetAggregate.getUser().getFollowers();

    final var hasMoreFollowersThanMin = followers > minFollowers;
    log.debug("Has more followers: {}", hasMoreFollowersThanMin);
    if (!hasMoreFollowersThanMin) {
      return false;
    }

    final var langList = this.tweetTestConfig.getLangs();
    log.debug("Accepted langs: {}", langList);

    final var langAccepted = langList.stream().anyMatch(l -> l.equals(tweetAggregate.getLang()));
    log.debug("Lange accepted: {}", langAccepted);

    if (!langAccepted) {
      return false;
    }

    return true;
  }
}
