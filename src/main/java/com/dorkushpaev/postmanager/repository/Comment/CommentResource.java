package com.dorkushpaev.postmanager.repository.Comment;

import com.dorkushpaev.postmanager.model.Comment;
import com.dorkushpaev.postmanager.service.Comment.CommentService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentResource {
    private final CommentService commentService;

    public CommentResource(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllComments(){
        List<Comment> comments = commentService.findAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") Long id){
        Comment comment = commentService.findCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        ZonedDateTime date = ZonedDateTime.now();
        comment.setCommentWroteAt(date);
        Comment newComment = commentService.saveComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);//создали новый пост
    }

    @PutMapping("/update")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment){
        Comment updateComment = commentService.updateComment(comment);
        return new ResponseEntity<>(updateComment, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCommentById(@PathVariable("id") Long id){//метод ничего не возвращает
        commentService.deleteCommentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAllCommentsByUserId/{id}")
    public ResponseEntity<List<Comment>> getAllCommentsByUserId(@PathVariable ("id") Long id){
        List<Comment> comments = commentService.getAllCommentsByUser(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
