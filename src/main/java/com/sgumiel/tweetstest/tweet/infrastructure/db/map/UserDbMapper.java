package com.sgumiel.tweetstest.tweet.infrastructure.db.map;

import com.sgumiel.tweetstest.tweet.domain.User;
import com.sgumiel.tweetstest.tweet.infrastructure.db.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDbMapper {

  User toDomain(UserEntity source);
  UserEntity toEntity(User source);
}
