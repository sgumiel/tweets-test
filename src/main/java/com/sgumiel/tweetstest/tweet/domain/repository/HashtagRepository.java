package com.sgumiel.tweetstest.tweet.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sgumiel.tweetstest.tweet.domain.Hashtag;

public interface HashtagRepository {

  Hashtag save(Hashtag hashtag);

  Optional<Hashtag> findByTag(String hashtagText);

  List<Hashtag> findTopOrderByOccurrences(Integer limit);
}
