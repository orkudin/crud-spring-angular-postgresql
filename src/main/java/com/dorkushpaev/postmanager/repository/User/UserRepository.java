package com.dorkushpaev.postmanager.repository.User;

import com.dorkushpaev.postmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
