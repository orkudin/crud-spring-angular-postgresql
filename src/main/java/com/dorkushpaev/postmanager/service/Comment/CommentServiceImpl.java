package com.dorkushpaev.postmanager.service.Comment;

import com.dorkushpaev.postmanager.exception.CommentNotFoundException;
import com.dorkushpaev.postmanager.model.Comment;
import com.dorkushpaev.postmanager.repository.Comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAllComments() {
        return this.commentRepository.findAll();
    }

    @Override
    public Comment saveComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(long id) {
        this.commentRepository.deleteById(id);
    }

    @Override
    public Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("Comment by id " + id + " was not found"));
    }

    @Override
    public List<Comment> getAllCommentsByUser(Long id) {
        return commentRepository.findCommentsByUserId(id);
    }
}
