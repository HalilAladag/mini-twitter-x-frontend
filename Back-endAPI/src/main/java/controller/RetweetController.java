package controller;

import entity.Retweet;
import entity.Tweet;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.RetweetService;
import service.TweetService;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/retweets")
public class RetweetController {

    private final RetweetService retweetService;

    @Autowired
    public RetweetController(RetweetService retweetService) {
        this.retweetService = retweetService;
    }
    @Autowired
    private TweetService tweetService;
    @Autowired
    private UserService userService;

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<Retweet>> getRetweetsByUser(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        List<Retweet> retweets = retweetService.getRetweetsByUser(user);
        return new ResponseEntity<>(retweets, HttpStatus.OK);
    }

    @GetMapping("/byTweet/{tweetId}")
    public ResponseEntity<List<Retweet>> getRetweetsByTweet(@PathVariable int tweetId) {
        Tweet tweet = tweetService.getTweetById(tweetId);
        List<Retweet> retweets = retweetService.getRetweetsByTweet(tweet);
        return new ResponseEntity<>(retweets, HttpStatus.OK);
    }

}

