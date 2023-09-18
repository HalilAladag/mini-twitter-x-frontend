package repository;

import entity.Followers;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowersRepository extends JpaRepository <Followers, Integer> {

    List <Followers> findByUser(User user);
    List<Followers> findByFollowers(User user);
}
