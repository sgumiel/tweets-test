package com.sgumiel.tweetstest.tweet.application.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.sgumiel.tweetstest.tweet.application.HashtagExtractorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HashtagExtractorServiceImpl implements HashtagExtractorService {

  private final Pattern HASHTAG_PATTERN = Pattern.compile("#(\\S+)");

  @Override
  public List<String> extract(String text) {

    log.debug("Extract hashtags from text: {}", text);
    final var matcher = HASHTAG_PATTERN.matcher(text);

    final var hashtagsList = new ArrayList<String>();

    while (matcher.find()) {
      hashtagsList.add(matcher.group(1));
    }

    log.debug("Hashtags: {}", hashtagsList);
    return hashtagsList;
  }
}
