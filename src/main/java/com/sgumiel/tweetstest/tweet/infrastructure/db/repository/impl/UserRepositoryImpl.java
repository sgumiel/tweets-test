package com.sgumiel.tweetstest.tweet.infrastructure.db.repository.impl;

import java.util.Optional;

import com.sgumiel.tweetstest.tweet.domain.User;
import com.sgumiel.tweetstest.tweet.domain.repository.UserRepository;
import com.sgumiel.tweetstest.tweet.infrastructure.db.jpa.UserJpaRepository;
import com.sgumiel.tweetstest.tweet.infrastructure.db.map.UserDbMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final UserJpaRepository userJpaRepository;
  private final UserDbMapper userDbMapper;

  @Override
  public Optional<User> findById(Long id) {

    log.debug("Find by id: {}", id);

    final var userEntityOp = this.userJpaRepository.findById(id);
    log.debug("User found: {}", userEntityOp.isPresent());

    final var userOp = userEntityOp.map( ue -> this.userDbMapper.toDomain(ue));
    log.debug("User entity mapped to domain");

    return userOp;
  }

  @Override
  public User saveIfNotExist(User user) {

    log.debug("Save user: {}", user);

    final var userEntityOp =  this.userJpaRepository.findById(user.getId());
    log.debug("User exists: {}", userEntityOp.isPresent());
    if(userEntityOp.isPresent()){
      return user;
    }

    final var userEntity = this.userDbMapper.toEntity(user);
    log.debug("User mapped to entity");

    final var userEntitySaved = this.userJpaRepository.save(userEntity);
    log.debug("User entity saved: {}", userEntitySaved);

    final var userSaved = this.userDbMapper.toDomain(userEntitySaved);
    log.debug("User entity mapped to domain");

    return userSaved;

  }
}
