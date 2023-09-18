package repository;

import entity.Retweet;
import entity.Tweet;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RetweetRepository extends JpaRepository<Retweet, Integer> {
    List<Retweet> findByUser(User user);
    List<Retweet> findByTweet(Tweet tweet);

}

