package com.sgumiel.tweetstest

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.sgumiel.tweetstest.tweet.infrastructure.db.jpa.TweetJpaRepository
import com.sgumiel.tweetstest.tweet.infrastructure.db.model.TweetEntity
import com.sgumiel.tweetstest.tweet.infrastructure.rest.model.TweetResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Shared
import spock.lang.Specification
import uk.co.jemos.podam.api.PodamFactoryImpl

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put

@AutoConfigureTestDatabase
@AutoConfigureMockMvc
@SpringBootTest(classes = TweetsTestApplication.class)
@ActiveProfiles("test")
class TweetControllerITSpec extends Specification{

    private static final GET_TWEETS_URI = "/tweets"
    private static final VALIDATE_TWEET_URI = "/tweets/%s/validate"
    private static final GET_TWEETS_VALIDATED_BY_USER_ID = "/tweets/validated/%s"

    @Autowired
    MockMvc mvc

    @Autowired
    ObjectMapper objectMapper

    @Autowired
    TweetJpaRepository tweetJpaRepository

    @Shared
    def podam = new PodamFactoryImpl()

    def "Test get tweets" () {

        given:

        when:
        def response = mvc.perform(get(GET_TWEETS_URI)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().response

        then: "the status code must be 200"
        response.status == HttpStatus.OK.value()

        and:
        def tweetsList = objectMapper.readValue(response.contentAsString, new TypeReference<List<TweetResponse>>() {})
        tweetsList.size() > 0

    }

    def "Test validate tweet does not exist" () {

        given:
        def tweetId = podam.manufacturePojoWithFullData(Long.class) % 100

        when:
        def uri = String.format(VALIDATE_TWEET_URI, tweetId)
        def response = mvc.perform(put(uri)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().response

        then: "the status code must be 200"
        response.status == HttpStatus.OK.value()

    }

    def "Test validate tweet " () {

        given:
        def tweetId = 1407999416011796481

        when:
        def uri = String.format(VALIDATE_TWEET_URI, tweetId)
        def response = mvc.perform(put(uri)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().response

        then: "the status code must be 200"
        response.status == HttpStatus.OK.value()

        and:
        def tweetOp = tweetJpaRepository.findById(1407999416011796481)
        tweetOp.isPresent()
        tweetOp.get().getValidated()

    }

    def "Get validated tweets by user id" () {

        given: "At least one tweet validated"
        def tweet = ((List<TweetEntity>)tweetJpaRepository.findAll()).stream().findFirst().get();
        def userId = tweet.getUserId()
        tweet.setValidated(true)
        tweetJpaRepository.save(tweet)

        when:
        def uri = String.format(GET_TWEETS_VALIDATED_BY_USER_ID, userId)
        def response = mvc.perform(get(uri)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().response

        then: "the status code must be 200"
        response.status == HttpStatus.OK.value()

        and:
        def tweetsList = objectMapper.readValue(response.contentAsString, new TypeReference<List<TweetResponse>>() {})
        tweetsList.size() > 0
        def allValidated = tweetsList.stream().allMatch({t -> t.getValidated() == true})
        allValidated == true

    }
}