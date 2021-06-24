package com.sgumiel.tweetstest.tweet.application.map;

import com.sgumiel.tweetstest.tweet.domain.Tweet;
import com.sgumiel.tweetstest.tweet.domain.TweetAggregate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TweetMapper {

  @Mapping(target = "userId", source = "user.id")
  @Mapping(target = "latitude", source = "location.latitude")
  @Mapping(target = "longitude", source = "location.longitude")
  Tweet toTweet(TweetAggregate source);
}
