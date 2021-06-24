package com.sgumiel.tweetstest.tweet.infrastructure.db.jpa;

import com.sgumiel.tweetstest.tweet.infrastructure.db.model.TweetEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetJpaRepository extends CrudRepository<TweetEntity, Long>, JpaSpecificationExecutor<TweetEntity> {
}
