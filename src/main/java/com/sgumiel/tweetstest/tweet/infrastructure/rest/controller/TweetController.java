package com.sgumiel.tweetstest.tweet.infrastructure.rest.controller;

import java.util.List;

import com.sgumiel.tweetstest.tweet.application.TweetService;
import com.sgumiel.tweetstest.tweet.domain.TweetFilter;
import com.sgumiel.tweetstest.tweet.infrastructure.rest.map.TweetRestMapper;
import com.sgumiel.tweetstest.tweet.infrastructure.rest.model.TweetResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("tweets")
public class TweetController {

  private final TweetService tweetService;
  private final TweetRestMapper tweetRestMapper;

  @Operation(summary = "Get all tweets")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "List of tweets",
                  content = {@Content(mediaType = "application/json",
                          schema = @Schema(implementation = TweetResponse.class))})})
  @GetMapping
  public ResponseEntity<List<TweetResponse>> findAll() {

    log.debug("Find all");

    final var tweetsList = this.tweetService.findAll();
    log.debug("Tweets found: {}", tweetsList.size());

    final var tweeetsResponseList = this.tweetRestMapper.toResponse(tweetsList);
    log.debug("Tweets mapped to response");

    return ResponseEntity.ok(tweeetsResponseList);

  }

  @Operation(summary = "Validate a tweet")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Validate a tweet",
                  content = {@Content(mediaType = "application/json",
                          schema = @Schema(implementation = Void.class))})})
  @PutMapping("{id}/validate")
  public ResponseEntity<Void> validateTweet(@PathVariable("id") Long id) {

    log.debug("Validate tweet id: {}", id);

    this.tweetService.validate(id);

    return ResponseEntity.ok().build();

  }

  @Operation(summary = "Get all tweets validated by user")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "List of tweets validated of an user",
                  content = {@Content(mediaType = "application/json",
                          schema = @Schema(implementation = TweetResponse.class))})})
  @GetMapping("validated/{userId}")
  public ResponseEntity<List<TweetResponse>> findAllTweetsValidatedByUserId(@PathVariable("userId") Long userId) {

    log.debug("Find all validated tweets by user id: {}", userId);

    final TweetFilter tweetFilter = TweetFilter.builder()
            .validated(true)
            .userId(userId)
            .build();

    final var tweetsList = this.tweetService.findByFilter(tweetFilter);
    log.debug("Tweets validated found: {}", tweetsList.size());

    final var tweeetsResponseList = this.tweetRestMapper.toResponse(tweetsList);
    log.debug("Tweets mapped to response");

    return ResponseEntity.ok(tweeetsResponseList);

  }

}
