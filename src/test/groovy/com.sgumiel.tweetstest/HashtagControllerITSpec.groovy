package com.sgumiel.tweetstest

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.sgumiel.tweetstest.tweet.infrastructure.db.jpa.TweetJpaRepository
import com.sgumiel.tweetstest.tweet.infrastructure.db.model.TweetEntity
import com.sgumiel.tweetstest.tweet.infrastructure.rest.model.HashtagResponse
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
class HashtagControllerITSpec extends Specification{

    private static final GET_HASHTAG_MOST_USDED_URI = "/hashtags"

    @Autowired
    MockMvc mvc

    @Autowired
    ObjectMapper objectMapper

    @Shared
    def podam = new PodamFactoryImpl()


    def "Test get most used hashtag" () {

        given:

        when:
        def response = mvc.perform(get(GET_HASHTAG_MOST_USDED_URI)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().response

        then: "the status code must be 200"
        response.status == HttpStatus.OK.value()

        and:
        def hashtagList = objectMapper.readValue(response.contentAsString, new TypeReference<List<HashtagResponse>>() {})
        hashtagList.size() > 0

    }
}
