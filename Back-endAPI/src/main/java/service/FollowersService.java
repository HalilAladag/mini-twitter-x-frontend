package service;

import entity.Followers;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FollowersRepository;

import java.util.List;

@Service
public class FollowersService {
    private final FollowersRepository followersRepository;

    @Autowired
    public FollowersService(FollowersRepository followersRepository) {
        this.followersRepository = followersRepository;
    }

    public List<Followers> getFollowersByUser(User user) {
        return followersRepository.findByUser(user);
    }

    public List<Followers> getUsersFollowing(User user) {
        return followersRepository.findByFollowers(user);
    }
}
