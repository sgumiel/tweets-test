package com.sgumiel.tweetstest.tweet.application;

import java.util.List;

import com.sgumiel.tweetstest.tweet.domain.Hashtag;

public interface HashtagService {

  List<Hashtag> saveTextAsHashtag(String text);

  List<Hashtag> findMostUsed();
}
