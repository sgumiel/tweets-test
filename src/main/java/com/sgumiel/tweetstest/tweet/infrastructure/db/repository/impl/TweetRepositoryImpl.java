package com.sgumiel.tweetstest.tweet.infrastructure.db.repository.impl;

import java.util.List;
import java.util.Optional;

import com.sgumiel.tweetstest.tweet.domain.Tweet;
import com.sgumiel.tweetstest.tweet.domain.TweetFilter;
import com.sgumiel.tweetstest.tweet.domain.repository.TweetRepository;
import com.sgumiel.tweetstest.tweet.infrastructure.db.jpa.TweetJpaRepository;
import com.sgumiel.tweetstest.tweet.infrastructure.db.map.TweetDbMapper;
import com.sgumiel.tweetstest.tweet.infrastructure.db.scpecification.TweetSpecificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TweetRepositoryImpl implements TweetRepository {

  private final TweetJpaRepository tweetJpaRepository;
  private final TweetDbMapper tweetDbMapper;
  private final TweetSpecificationService tweetSpecificationService;

  @Override
  public Tweet save(Tweet tweet) {

    log.debug("Save tweet: {}", tweet);

    final var tweetEntity = this.tweetDbMapper.toEntity(tweet);
    log.debug("Tweet mapped to entity");

    final var tweetEntitySaved = this.tweetJpaRepository.save(tweetEntity);
    log.debug("Tweet entity saved: {}", tweetEntitySaved);

    final var tweetSaved = this.tweetDbMapper.toDomain(tweetEntitySaved);
    log.debug("Tweet entity mapped to domain");

    return tweetSaved;
  }

  @Override
  public List<Tweet> findAll() {

    log.debug("Find all");

    final var tweetsEntityList = (List)this.tweetJpaRepository.findAll();
    log.debug("Tweets found: {}", tweetsEntityList.size());

    final var tweetsList = this.tweetDbMapper.toDomain(tweetsEntityList);
    log.debug("Tweet entity list mapped to domain");

    return tweetsList;
  }

  @Override
  public Optional<Tweet> findById(Long id) {

    log.debug("Find by id: {}", id);

    final var tweetEntityOp = this.tweetJpaRepository.findById(id);
    log.debug("tweet found: {}", tweetEntityOp.isPresent());

    final var tweetOp = tweetEntityOp.map( te -> this.tweetDbMapper.toDomain(te));
    log.debug("Tweet entity mapped");

    return tweetOp;
  }

  @Override
  public List<Tweet> findByFilter(TweetFilter tweetFilter) {

    log.debug("Tweet by filter: {}", tweetFilter);

    final var tweetSpecification = this.tweetSpecificationService.createDefaultSpecification(tweetFilter);

    final var tweetsEntityList = this.tweetJpaRepository.findAll(tweetSpecification);
    log.debug("Tweet list size: {}", tweetsEntityList.size());

    final var tweetsList = this.tweetDbMapper.toDomain(tweetsEntityList);
    log.debug("Tweet entity list mapped to domain");

    return tweetsList;
  }
}