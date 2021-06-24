package com.sgumiel.tweetstest.tweet.application.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.sgumiel.tweetstest.config.TweetTestGetConfig;
import com.sgumiel.tweetstest.tweet.application.HashtagExtractorService;
import com.sgumiel.tweetstest.tweet.application.HashtagService;
import com.sgumiel.tweetstest.tweet.application.function.HashtagTextConsumer;
import com.sgumiel.tweetstest.tweet.domain.Hashtag;
import com.sgumiel.tweetstest.tweet.domain.repository.HashtagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HashtagServiceImpl implements HashtagService {

  private final HashtagExtractorService hashtagExtractorService;
  private final HashtagTextConsumer hashtagTextConsumer;
  private final TweetTestGetConfig tweetTestGetConfig;
  private final HashtagRepository hashtagRepository;

  @Override
  public List<Hashtag> saveTextAsHashtag(String text) {

    log.debug("Save text as hashtags: {}", text);

    final var hashtagTextList = this.hashtagExtractorService.extract(text);

    final var hashtagList = hashtagTextList.stream()
            .map( hashtagText -> this.hashtagTextConsumer.apply(hashtagText))
            .collect(Collectors.toList());

    return hashtagList;
  }

  @Override
  public List<Hashtag> findMostUsed() {

    log.debug("Find most used: {}", this.tweetTestGetConfig.getHashtag());

    final var hashtagList = this.hashtagRepository.findTopOrderByOccurrences(this.tweetTestGetConfig.getHashtag());
    log.debug("Hashtags found: {}", hashtagList);

    return hashtagList;

  }
}