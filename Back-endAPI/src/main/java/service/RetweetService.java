package service;

import entity.Retweet;
import entity.Tweet;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RetweetRepository;

import java.util.List;

@Service
public class RetweetService {
    private final RetweetRepository retweetRepository;

    @Autowired
    public RetweetService(RetweetRepository retweetRepository) {
        this.retweetRepository = retweetRepository;
    }

    public List<Retweet> getRetweetsByUser(User user) {
        return retweetRepository.findByUser(user);
    }

    public List<Retweet> getRetweetsByTweet(Tweet tweet) {
        return retweetRepository.findByTweet(tweet);
    }
}
