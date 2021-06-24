package com.sgumiel.tweetstest.tweet.infrastructure.rest.map;

import java.util.List;

import com.sgumiel.tweetstest.tweet.domain.Hashtag;
import com.sgumiel.tweetstest.tweet.infrastructure.rest.model.HashtagResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HashtagRestMapper {

  HashtagResponse toResponse(Hashtag source);

  List<HashtagResponse> toResponse(List<Hashtag> source);
}
