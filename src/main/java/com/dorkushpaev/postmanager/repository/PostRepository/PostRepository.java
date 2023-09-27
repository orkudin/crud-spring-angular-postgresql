package com.dorkushpaev.postmanager.repository.PostRepository;

import com.dorkushpaev.postmanager.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByUserId(Long id);
}
