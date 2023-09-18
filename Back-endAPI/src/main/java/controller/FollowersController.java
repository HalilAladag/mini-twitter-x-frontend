package controller;

import entity.Followers;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FollowersService;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/followers")
public class FollowersController {

    private final FollowersService followersService;

    @Autowired
    public FollowersController(FollowersService followersService) {
        this.followersService = followersService;
    }
    @Autowired
    private UserService userService;


    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<Followers>> getFollowersByUser(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        List<Followers> followers = followersService.getFollowersByUser(user);
        return new ResponseEntity<>(followers, HttpStatus.OK);
    }

    @GetMapping("/following/{userId}")
    public ResponseEntity<List<Followers>> getUsersFollowing(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        List<Followers> following = followersService.getUsersFollowing(user);
        return new ResponseEntity<>(following, HttpStatus.OK);
    }

}

