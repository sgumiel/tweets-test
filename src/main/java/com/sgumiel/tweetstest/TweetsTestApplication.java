package com.sgumiel.tweetstest;

import com.sgumiel.tweetstest.flag.TwitterSignedInFlag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class TweetsTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(TweetsTestApplication.class, args);
  }

  @Bean
  public TwitterSignedInFlag twitterSignedInFlag() {
    return new TwitterSignedInFlag();
  }

}