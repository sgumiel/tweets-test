package com.sgumiel.tweetstest.tweet.infrastructure.db.repository.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sgumiel.tweetstest.tweet.domain.Hashtag;
import com.sgumiel.tweetstest.tweet.domain.repository.HashtagRepository;
import com.sgumiel.tweetstest.tweet.infrastructure.db.jpa.HashtagJpaRepository;
import com.sgumiel.tweetstest.tweet.infrastructure.db.map.HashtagDbMapper;
import com.sgumiel.tweetstest.tweet.infrastructure.db.model.HashtagEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HashtagRepositoryImpl implements HashtagRepository {

  private final HashtagJpaRepository hashtagJpaRepository;
  private final HashtagDbMapper hashtagDbMapper;

  @Override
  public Hashtag save(Hashtag hashtag) {

    log.debug("Save hashtag: {}", hashtag);

    final var hashtagEntity = this.hashtagDbMapper.toEntity(hashtag);
    log.debug("hashtag mapped to entity");

    final var hashtagEntitySaved = this.hashtagJpaRepository.save(hashtagEntity);
    log.debug("hashtag entity saved: {}", hashtagEntitySaved);

    final var hashtagSaved = this.hashtagDbMapper.toDomain(hashtagEntitySaved);
    log.debug("hashtag entity mapped to domain");

    return hashtagSaved;
  }

  @Override
  public Optional<Hashtag> findByTag(String hashtagText) {

    log.debug("Find by tag: {}", hashtagText);

    final var hashtagEntityOp = this.hashtagJpaRepository.findByTag(hashtagText);
    log.debug("Hashtag found: {}", hashtagEntityOp.isPresent());

    final var hashtagOp = hashtagEntityOp.map( he -> this.hashtagDbMapper.toDomain(he));
    log.debug("hashtag entity mapped to domain");

    return hashtagOp;
  }

  @Override
  public List<Hashtag> findTopOrderByOccurrences(Integer limit) {

    log.debug("Find order by occurrencies limit to: {}", limit);

    final var hashtagEntityList = (List<HashtagEntity>)this.hashtagJpaRepository.findAll();
    log.debug("Hashtag found: {}", hashtagEntityList.size());

    final var hashtagEntityOrderedLimit = hashtagEntityList.stream()
            .sorted(Comparator.comparingInt(HashtagEntity::getOccurrences))
            .limit(limit)
            .collect(Collectors.toList());
    log.debug("Hashtag list ordered and limited: {}", hashtagEntityOrderedLimit);

    final var hashtagList = this.hashtagDbMapper.toDomain(hashtagEntityOrderedLimit);
    log.debug("hashtag entity list mapped to domain");

    return hashtagList;
  }
}
