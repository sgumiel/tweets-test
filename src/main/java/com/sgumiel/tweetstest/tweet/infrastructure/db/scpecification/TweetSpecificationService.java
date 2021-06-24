package com.sgumiel.tweetstest.tweet.infrastructure.db.scpecification;

import com.sgumiel.tweetstest.tweet.domain.TweetFilter;
import com.sgumiel.tweetstest.tweet.infrastructure.db.model.TweetEntity;
import org.springframework.data.jpa.domain.Specification;

public interface TweetSpecificationService {

  Specification<TweetEntity> createDefaultSpecification(TweetFilter tweetFilter);
}
