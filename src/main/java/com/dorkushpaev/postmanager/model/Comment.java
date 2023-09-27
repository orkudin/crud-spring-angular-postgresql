package com.dorkushpaev.postmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "comments")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(nullable = false, updatable = false, name = "comment_id")
    private long commentId;
    @Column(insertable = false, nullable = false, updatable = false, name = "post_id")
    private long postId;
    @Column(insertable = false, nullable = false, updatable = false, name = "user_id")
    private long userId;

    private String commentText;
    private ZonedDateTime commentWroteAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="POST_ID", nullable = false)
    @JsonIgnore
    private Post post;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", userId=" + userId +
                ", commentText='" + commentText + '\'' +
                ", commentWroteAt=" + commentWroteAt +
                '}';
    }
}
