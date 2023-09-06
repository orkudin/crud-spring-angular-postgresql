package com.dorkushpaev.postmanager.service;

import com.dorkushpaev.postmanager.exception.PostNotFoundException;
import com.dorkushpaev.postmanager.model.Post;
import com.dorkushpaev.postmanager.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAllPosts() {
        return this.postRepository.findAll();
    }

    @Override
    public Post savePost(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public void deletePostById(long id) {
        this.postRepository.deleteById(id);
    }

    @Override
    public Post findPostById(Long id) {
//        Optional<Post> optionalPost = postRepository.findById(id);
//        Post post = null;
//        if (optionalPost.isPresent()) {
//            post = optionalPost.get();
//        } else {
//            throw new RuntimeException(" Post not found by id ::" + id);
//        }
//        return post;

        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post by id " + id + " was not found"));
    }


}
