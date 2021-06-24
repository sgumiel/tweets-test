package com.sgumiel.tweetstest.tweet.infrastructure.db.jpa;

import java.util.Optional;

import com.sgumiel.tweetstest.tweet.infrastructure.db.model.HashtagEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagJpaRepository extends CrudRepository<HashtagEntity, Long> {

  Optional<HashtagEntity> findByTag(String tag);

}
