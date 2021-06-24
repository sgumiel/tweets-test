package com.sgumiel.tweetstest.tweet.application;

import java.util.List;

public interface HashtagExtractorService {

  List<String> extract(String text);
}
