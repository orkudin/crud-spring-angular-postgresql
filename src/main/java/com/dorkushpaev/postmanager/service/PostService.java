package com.dorkushpaev.postmanager.service;

import com.dorkushpaev.postmanager.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllPosts();
    Post savePost(Post post);
    Post updatePost(Post post);
    void deletePostById(long id);
    Post findPostById(Long id);

}
