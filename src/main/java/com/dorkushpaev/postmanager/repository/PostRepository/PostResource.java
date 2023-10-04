package com.dorkushpaev.postmanager.repository.PostRepository;

import com.dorkushpaev.postmanager.model.Post;
import com.dorkushpaev.postmanager.model.User;
import com.dorkushpaev.postmanager.service.PostService.PostService;
import com.dorkushpaev.postmanager.service.UserService.UserService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostResource {
    private final PostService postService;
    private final UserService userService;

    public PostResource(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts = postService.findAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id){
        Post post = postService.findPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        LocalDateTime date = LocalDateTime.now();
        post.setPostCreatedAt(date);
        User user = userService.findUserById(2L);
        post.setUserId(user.getUserId());
        post.setUser(user);
        Post newPost = postService.savePost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);//создали новый пост
    }

    @PutMapping("/update")
    public ResponseEntity<Post> updatePost(@RequestBody Post post){
        System.out.println(post);
        User user = userService.findUserById(2L);
        post.setUserId(user.getUserId());
        post.setUser(user);
        Post updatePost = postService.updatePost(post);
        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable("id") Long id){//метод ничего не возвращает
        postService.deletePostById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAllPostsByUserId/{id}")
    public ResponseEntity<List<Post>> getAllPostsByUserId(@PathVariable("id") Long id){
        List<Post> posts = postService.getAllPostsByUser(id);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

}
