package com.sgumiel.tweetstest

import com.sgumiel.tweetstest.tweet.application.TweetService
import com.sgumiel.tweetstest.tweet.domain.TweetAggregate
import com.sgumiel.tweetstest.tweet.domain.User
import com.sgumiel.tweetstest.tweet.infrastructure.db.jpa.TweetJpaRepository
import com.sgumiel.tweetstest.tweet.infrastructure.tweet4j.config.TweetTestSaveConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Shared
import spock.lang.Specification
import uk.co.jemos.podam.api.PodamFactoryImpl

@AutoConfigureTestDatabase
@SpringBootTest(classes = TweetsTestApplication.class)
@ActiveProfiles("test")
class SaveTweetTest extends Specification {

    @Autowired
    private TweetService tweetService;

    @Autowired
    private TweetJpaRepository tweetJpaRepository;

    @Autowired
    private TweetTestSaveConfig tweetTestSaveConfig;

    @Shared
    def podam = new PodamFactoryImpl()

    def "Save tweet when its user does not have enough followers" () {

        given:
        def minFollowers = this.tweetTestSaveConfig.getMinFollowersToSave();
        def tweetAggregate = TweetAggregate.builder()
        .id(1)
        .user(User.builder().id(1).name("test").followers(minFollowers-1).build())
        .text(podam.manufacturePojoWithFullData(String.class))
        .lang("es")
        .validated(false)
        .build();

        when:
        def response = this.tweetService.save(tweetAggregate);

        then: "The tweet must not be exists in the bbdd"
        def tweetOp = this.tweetJpaRepository.findById(tweetAggregate.getId())
        tweetOp.isEmpty() == true
    }

    def "Save tweet when the lang is not accepted" () {

        given:
        def minFollowers = this.tweetTestSaveConfig.getMinFollowersToSave();
        def tweetAggregate = TweetAggregate.builder()
                .id(1)
                .user(User.builder().id(1).name("test").followers(minFollowers-1).build())
                .text(podam.manufacturePojoWithFullData(String.class))
                .lang("ZZ")
                .validated(false)
                .build();

        when:
        def response = this.tweetService.save(tweetAggregate);

        then: "The tweet must not be exists in the bbdd"
        def tweetOp = this.tweetJpaRepository.findById(tweetAggregate.getId())
        tweetOp.isEmpty() == true
    }

    def "Save tweet success" () {

        given:
        def minFollowers = this.tweetTestSaveConfig.getMinFollowersToSave();
        def tweetAggregate = TweetAggregate.builder()
                .id(1)
                .user(User.builder().id(1).name("test").followers(minFollowers+1).build())
                .text(podam.manufacturePojoWithFullData(String.class))
                .lang("es")
                .validated(false)
                .build();

        when:
        def response = this.tweetService.save(tweetAggregate);

        then: "The tweet must be exists in the bbdd"
        def tweetOp = this.tweetJpaRepository.findById(tweetAggregate.getId())
        tweetOp.isPresent() == true
    }
}
