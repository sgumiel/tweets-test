package com.sgumiel.tweetstest.tweet.infrastructure.db.scpecification.impl;

import java.util.function.Predicate;

import com.sgumiel.tweetstest.tweet.domain.TweetFilter;
import com.sgumiel.tweetstest.tweet.infrastructure.db.model.TweetEntity;
import com.sgumiel.tweetstest.tweet.infrastructure.db.scpecification.TweetSpecificationService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TweetSpecificationServiceImpl implements TweetSpecificationService {

  @Override
  public Specification<TweetEntity> createDefaultSpecification(TweetFilter tweetFilter) {

    var spec = Specification.<TweetEntity>where(null);

    if (tweetFilter == null) {
      return spec;
    }

    if (tweetFilter.getValidated() != null) {
      spec = spec.and((root, cq, cb) -> cb.equal(root.get("validated"), tweetFilter.getValidated()));
    }

    if (tweetFilter.getUserId() != null) {
      spec = spec.and((root, cq, cb) -> cb.equal(root.get("userId"), tweetFilter.getUserId()));
    }

    return spec;
  }
}
