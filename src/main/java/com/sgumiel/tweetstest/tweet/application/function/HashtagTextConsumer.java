package com.sgumiel.tweetstest.tweet.application.function;

import java.util.function.Function;

import com.sgumiel.tweetstest.tweet.domain.Hashtag;
import com.sgumiel.tweetstest.tweet.domain.repository.HashtagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HashtagTextConsumer implements Function<String, Hashtag> {

  private final HashtagRepository hashtagRepository;

  @Override
  public Hashtag apply(String hashtagText) {

    log.debug("Processing hashtag: {}", hashtagText);

    final var hashtagOp = this.hashtagRepository.findByTag(hashtagText);
    log.debug("Hashtag found: {}", hashtagOp.isPresent());

    if (hashtagOp.isEmpty()) {
      final var hashtag = Hashtag.builder()
              .tag(hashtagText)
              .occurrences(1)
              .build();
      final var hashtagSaved = this.hashtagRepository.save(hashtag);
      log.debug("Hashtag saved: {}", hashtagSaved);
      return hashtagSaved;
    }

    final var hashtag = hashtagOp.get();
    hashtag.setOccurrences(hashtag.getOccurrences() + 1);
    final var hashtagUpdated = this.hashtagRepository.save(hashtag);
    log.debug("Hashtag updated: {}", hashtagUpdated);
    return hashtagUpdated;
  }
}
