package com.sgumiel.tweetstest.tweet.infrastructure.tweet4j.map;

import com.sgumiel.tweetstest.tweet.domain.TweetAggregate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import twitter4j.Status;

@Mapper(componentModel = "spring")
public interface Tweet4jMapper {

  @Mapping(target = "user.id", source = "user.id")
  @Mapping(target = "validated", expression = "java(false)")
  @Mapping(target = "user.followers", source="user.followersCount")
  @Mapping(target = "location.latitude", source="geoLocation.latitude")
  @Mapping(target = "location.longitude", source="geoLocation.longitude")
  TweetAggregate toDomain(Status source);
}
