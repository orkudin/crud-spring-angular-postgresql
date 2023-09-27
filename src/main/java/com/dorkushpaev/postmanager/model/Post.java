package com.dorkushpaev.postmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "posts")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "post_id")
    private long postId;
    private String postTitle;
    private String postDescription;
    private LocalDateTime postCreatedAt;
    private int postVotes;
    @Column(insertable = false, nullable = false, updatable = false, name = "user_id")
    private Long userId;
    private String urlImage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="USER_ID", nullable = false)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "post",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Comment> comments;


    public void addComment(Comment comment){
        comments.add(comment);
        comment.setPost(this);
    }

    public void deleteComment(Comment comment){
        comments.remove(comment);
        comment.setPost(null);
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Post post = (Post) o;
        return postId == post.postId;
    }

    @Override
    public int hashCode() {
        return Objects.hash( postId );
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postDescription='" + postDescription + '\'' +
                ", postCreatedAt=" + postCreatedAt +
                ", postVotes=" + postVotes +
                ", userId=" + userId +
                ", urlImage='" + urlImage + '\'' +
                ", user=" + user +
                '}';
    }
}
