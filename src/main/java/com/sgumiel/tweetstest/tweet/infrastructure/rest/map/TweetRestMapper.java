package com.sgumiel.tweetstest.tweet.infrastructure.rest.map;

import java.util.List;

import com.sgumiel.tweetstest.tweet.domain.Tweet;
import com.sgumiel.tweetstest.tweet.infrastructure.rest.model.TweetResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TweetRestMapper {

  TweetResponse toResponse(Tweet source);

  List<TweetResponse> toResponse(List<Tweet> source);
}
