package controller;

import entity.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TweetService;


@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    private final TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping("/create")
    public ResponseEntity<Tweet> createTweet(@RequestBody Tweet tweet) {
        Tweet createdTweet = tweetService.createTweet(tweet);
        return new ResponseEntity<>(createdTweet, HttpStatus.CREATED);
    }

    @PostMapping("/retweet/{tweetId}")
    public ResponseEntity<Tweet> retweet(@PathVariable int tweetId, @RequestBody Tweet tweet) {
        Tweet retweetedTweet = tweetService.retweet(tweetId, tweet.getUser());
        return new ResponseEntity<>(retweetedTweet, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{tweetId}")
    public ResponseEntity<Void> deleteTweet(@PathVariable int tweetId) {
        tweetService.deleteTweet(tweetId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/like/{tweetId}")
    public ResponseEntity<Void> likeTweet(@PathVariable int tweetId, @RequestBody Tweet tweet) {
        tweetService.likeTweet(tweetId, tweet.getUser());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/unlike/{tweetId}")
    public ResponseEntity<Void> unlikeTweet(@PathVariable int tweetId, @RequestBody Tweet tweet) {
        tweetService.unlikeTweet(tweetId, tweet.getUser());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{tweetId}")
    public ResponseEntity<Tweet> getTweetById(@PathVariable int tweetId) {
        Tweet tweet = tweetService.getTweetById(tweetId);
        return new ResponseEntity<>(tweet, HttpStatus.OK);
    }
}
