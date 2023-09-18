package repository;

import entity.Like;
import entity.Retweet;
import entity.Tweet;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository <Tweet, Integer> {
    List<Tweet> findTweetsByUser(User user);

    List<Like> findLikesByTweet(Tweet tweet);

    List<Retweet> findRetweetsByTweet(Tweet tweet);

    //TODO: Reply entity & table (maybe)
    //List<Reply> findRepliesByTweet(Tweet tweet);
}
