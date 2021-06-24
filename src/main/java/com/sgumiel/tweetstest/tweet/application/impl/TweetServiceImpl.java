package com.sgumiel.tweetstest.tweet.application.impl;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import com.sgumiel.tweetstest.tweet.application.CheckTweetService;
import com.sgumiel.tweetstest.tweet.application.HashtagService;
import com.sgumiel.tweetstest.tweet.application.TweetService;
import com.sgumiel.tweetstest.tweet.application.map.TweetMapper;
import com.sgumiel.tweetstest.tweet.domain.Tweet;
import com.sgumiel.tweetstest.tweet.domain.TweetAggregate;
import com.sgumiel.tweetstest.tweet.domain.TweetFilter;
import com.sgumiel.tweetstest.tweet.domain.repository.TweetRepository;
import com.sgumiel.tweetstest.tweet.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {

  private final TweetRepository tweetRepository;
  private final UserRepository userRepository;
  private final CheckTweetService checkTweetService;
  private final TweetMapper tweetMapper;
  private final HashtagService hashtagService;

  @Override
  public List<Tweet> findAll() {

    log.debug("Find all");

    final var tweetsList = this.tweetRepository.findAll();
    log.debug("Tweets found: {}", tweetsList.size());

    return tweetsList;
  }

  @Override
  @Transactional
  public TweetAggregate save(TweetAggregate tweetAggregate) {

    log.debug("Save tweet: {}", tweetAggregate);

    final var saveTweet = this.checkTweetService.check(tweetAggregate);
    log.debug("Save tweet check: {}", saveTweet);

    if (!saveTweet) {
      return tweetAggregate;
    }

    final var user = this.userRepository.saveIfNotExist(tweetAggregate.getUser());
    final var tweet = this.tweetMapper.toTweet(tweetAggregate);
    final var tweetSaved = this.tweetRepository.save(tweet);

    final var text = tweet.getText();
    final var hashtagList = this.hashtagService.saveTextAsHashtag(text);
    log.debug("Hashtag list saved: {}", hashtagList);

    return tweetAggregate;

  }

  @Override
  @Transactional
  public void validate(Long id) {

    log.debug("Validate tweet id: {}", id);

    final Optional<Tweet> tweetOp = this.tweetRepository.findById(id);
    log.debug("Tweet found: {}", tweetOp.isPresent());

    if (tweetOp.isEmpty()) {
      return;
    }

    final var tweet = tweetOp.get();
    tweet.setValidated(true);

    this.tweetRepository.save(tweet);
    log.debug("Tweet validated");

  }

  @Override
  public List<Tweet> findByFilter(TweetFilter tweetFilter) {

    log.debug("Find by filter: {}", tweetFilter);

    final var tweetList = this.tweetRepository.findByFilter(tweetFilter);
    log.debug("Tweets found: {}", tweetList);

    return tweetList;
  }
}