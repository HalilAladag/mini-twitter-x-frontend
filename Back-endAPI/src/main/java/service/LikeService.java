package service;

import entity.Like;
import entity.Tweet;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LikeRepository;
import repository.TweetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private TweetRepository tweetRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public List<Like> getLikesByUser(User user) {
        return likeRepository.findByUser(user);
    }

    public List<Like> getLikesByTweet(Tweet tweet) {
        return likeRepository.findByTweet(tweet);
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
