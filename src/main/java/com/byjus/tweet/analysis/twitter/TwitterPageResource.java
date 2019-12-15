package com.byjus.tweet.analysis.twitter;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/tweet")
public class TwitterPageResource {

    @Autowired
    private Twitter twitter;

    @RequestMapping(value = "/search", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tweet> getTweets(@RequestParam(value = "hashTag") String hashTag,
                                 @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) throws UnirestException, IOException {

        return twitter.searchOperations().search(hashTag, pageSize).getTweets();
    }
}

