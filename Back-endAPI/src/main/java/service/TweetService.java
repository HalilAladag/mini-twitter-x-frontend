package service;

import entity.Like;
import entity.Retweet;
import entity.Tweet;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LikeRepository;
import repository.RetweetRepository;
import repository.TweetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TweetService {
    private final TweetRepository tweetRepository;
    private final LikeRepository likeRepository;
    private final RetweetRepository retweetRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository, LikeRepository likeRepository, RetweetRepository retweetRepository) {
        this.tweetRepository = tweetRepository;
        this.likeRepository = likeRepository;
        this.retweetRepository = retweetRepository;
    }

    public List<Tweet> getTweetsByUser(User user) {
        return tweetRepository.findTweetsByUser(user);
    }

    public List<Like> getLikesByTweet(Tweet tweet) {
        return likeRepository.findByTweet(tweet);
    }

    public List<Retweet> getRetweetsByTweet(Tweet tweet) {
        return retweetRepository.findByTweet(tweet);
    }

    public Tweet getTweetById(int tweetId) {
        return tweetRepository.findById(tweetId).orElse(null);
    }

    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    public Tweet retweet(int tweetId, User user) {
        Tweet tweet = tweetRepository.findById(tweetId).orElse(null);
        if (tweet != null) {
            Retweet retweet = new Retweet();
            retweet.setUser(user);
            retweet.setTweet(tweet);
            retweetRepository.save(retweet);
        }
        return tweet;
    }

    public Tweet editTweet(int tweetId, String newContent) {
        Tweet tweet = tweetRepository.findById(tweetId).orElse(null);
        if (tweet != null) {
            tweet.setMessage(newContent);
            tweetRepository.save(tweet);
        }
        return tweet;
    }

    public void deleteTweet(int tweetId) {
        tweetRepository.deleteById(tweetId);
    }

    public Like likeTweet(int tweetId, User user) {
        Tweet tweet = tweetRepository.findById(tweetId).orElse(null);
        Like like = null;
        if (tweet != null) {
            like = new Like();
            like.setUser(user);
            like.setTweet(tweet);
            likeRepository.save(like);
        }
        return like;
    }

    public void unlikeTweet(int tweetId, User user) {
        Tweet tweet = tweetRepository.findById(tweetId).orElse(null);
        Like like = null;
        if (tweet != null) {
            Optional<Like> likeOptional = likeRepository.findByUserAndTweet(user, tweet);
            if (likeOptional.isPresent()) {
                like = likeOptional.get();
                likeRepository.delete(like);
            }
        }
    }


}
