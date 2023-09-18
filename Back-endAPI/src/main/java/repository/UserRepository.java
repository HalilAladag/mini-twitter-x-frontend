package repository;

import entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Integer> {

    User findByUsername(String username);
    List <Followers> findFollowersByUser(User user);
    List <Followers> findUserFollowing(User user);
    List <Tweet> findTweetsByUser(User user);
    List <Like> findLikesByUser(User user);
    List<Retweet> findRetweetsByUser(User user);
}
