package com.sgumiel.tweetstest.tweet.infrastructure.db.map;

import java.util.List;

import com.sgumiel.tweetstest.tweet.domain.Hashtag;
import com.sgumiel.tweetstest.tweet.infrastructure.db.model.HashtagEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HashtagDbMapper {

  HashtagEntity toEntity(Hashtag source);

  Hashtag toDomain(HashtagEntity source);

  List<Hashtag> toDomain(List<HashtagEntity> source);
}
