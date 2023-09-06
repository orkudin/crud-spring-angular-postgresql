package com.dorkushpaev.postmanager.repository;

import com.dorkushpaev.postmanager.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
