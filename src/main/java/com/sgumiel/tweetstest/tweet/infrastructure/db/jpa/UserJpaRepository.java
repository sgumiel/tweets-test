package com.sgumiel.tweetstest.tweet.infrastructure.db.jpa;

import com.sgumiel.tweetstest.tweet.infrastructure.db.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends CrudRepository<UserEntity, Long> {
}
