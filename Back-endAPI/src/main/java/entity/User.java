package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema = "twClone", name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="user_name", nullable = false)
    private String username;
    @Column(name ="name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Tweet> tweets;

    @OneToMany(mappedBy = "user")
    private List<Followers> followers;

    @OneToMany(mappedBy = "user")
    private List<Retweet> retweets;

    @OneToMany(mappedBy = "user")
    private List<Like> likes;


}
