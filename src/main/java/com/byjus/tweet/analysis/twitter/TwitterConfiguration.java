package com.byjus.tweet.analysis.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class TwitterConfiguration {

    @Value("${twitter-api-key}")
    private String apiKey;

    @Value("${twitter-api-secret-key}")
    private String apiSecretKey;

    @Value("${twitter-api-access-token}")
    private String apiAccessToken;

    @Value("${twitter-api-access-token-secret}")
    private String apiAccessTokenSecret;

    @Bean
    TwitterTemplate getTwtTemplate(){
        return new TwitterTemplate(apiKey, apiSecretKey, apiAccessToken, apiAccessTokenSecret);
    }
}
