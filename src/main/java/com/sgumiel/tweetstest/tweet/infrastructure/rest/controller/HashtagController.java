package com.sgumiel.tweetstest.tweet.infrastructure.rest.controller;

import java.util.List;

import com.sgumiel.tweetstest.tweet.application.HashtagService;
import com.sgumiel.tweetstest.tweet.infrastructure.rest.map.HashtagRestMapper;
import com.sgumiel.tweetstest.tweet.infrastructure.rest.model.HashtagResponse;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("hashtags")
public class HashtagController {

  private final HashtagRestMapper hashtagRestMapper;
  private final HashtagService hashtagService;

  @Operation(summary = "Get a list of most used hashtag")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "List of hashtags most used",
                  content = {@Content(mediaType = "application/json",
                          schema = @Schema(implementation = HashtagResponse.class))})})
  @GetMapping
  public ResponseEntity<List<HashtagResponse>> findMostUsed() {

    log.debug("Find most used");

    final var hashtagsList = this.hashtagService.findMostUsed();
    log.debug("Hashtags found: {}", hashtagsList.size());

    final var hashtagResponseList = this.hashtagRestMapper.toResponse(hashtagsList);
    log.debug("Hashtags mapped to response");

    return ResponseEntity.ok(hashtagResponseList);

  }
}
