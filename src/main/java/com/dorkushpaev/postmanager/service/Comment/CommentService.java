package com.dorkushpaev.postmanager.service.Comment;

import com.dorkushpaev.postmanager.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAllComments();
    Comment saveComment(Comment comment);
    Comment updateComment(Comment comment);
    void deleteCommentById(long id);
    Comment findCommentById(Long id);
    List<Comment> getAllCommentsByUser(Long id);
    List<Comment> getAllCommentsByPost(Long id);
}
