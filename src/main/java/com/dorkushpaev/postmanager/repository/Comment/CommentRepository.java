package com.dorkushpaev.postmanager.repository.Comment;

import com.dorkushpaev.postmanager.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByUserId(Long id);
}
