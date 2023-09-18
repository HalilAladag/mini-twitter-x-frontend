package repository;

import entity.Like;
import entity.Tweet;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository <Like, Integer> {

    List <Like> findByUser (User user);
    List <Like> findByTweet (Tweet tweet);
    Optional<Like> findByUserAndTweet(User user, Tweet tweet);
}
