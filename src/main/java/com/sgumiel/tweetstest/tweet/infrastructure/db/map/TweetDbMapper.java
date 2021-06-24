package com.sgumiel.tweetstest.tweet.infrastructure.db.map;

import java.util.List;

import com.sgumiel.tweetstest.tweet.domain.Tweet;
import com.sgumiel.tweetstest.tweet.infrastructure.db.model.TweetEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TweetDbMapper {

  TweetEntity toEntity(Tweet source);

  Tweet toDomain(TweetEntity source);

  List<Tweet> toDomain(List<TweetEntity> source);
}
