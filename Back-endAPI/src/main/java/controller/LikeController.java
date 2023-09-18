package controller;

import entity.Like;
import entity.Tweet;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.LikeService;
import service.TweetService;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;
    private UserService userService;
    private TweetService tweetService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<Like>> getLikesByUser(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        List<Like> likes = likeService.getLikesByUser(user);
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @GetMapping("/byTweet/{tweetId}")
    public ResponseEntity<List<Like>> getLikesByTweet(@PathVariable int tweetId) {
        Tweet tweet = tweetService.getTweetById(tweetId);
        List<Like> likes = likeService.getLikesByTweet(tweet);
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

}

