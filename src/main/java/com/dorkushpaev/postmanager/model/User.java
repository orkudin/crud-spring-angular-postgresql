package com.dorkushpaev.postmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(nullable = false, updatable = false, name = "user_id")
    private long userId;
    private String username;
    private String userPassword;
    private String userAbout;
    private String userProfileImg;
    private String userRole ;
    private LocalDateTime userJoinedAt;
    private String userStatus;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post){
        posts.add(post);
        post.setUser(this);
    }

    public void deletePost(Post post){
        posts.remove(post);
        post.setUser(null);
    }

    public void setPosts(List<Post> posts) {
        if(posts != null){
            posts.forEach(post->{
                post.setUser(this);
            });
        }
        this.posts = posts;
    }
}
