package com.dorkushpaev.postmanager.service.UserService;

import com.dorkushpaev.postmanager.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User saveUser(User user);
    User updateUser(User user);
    void deleteUserById(long id);
    User findUserById(Long id);
}
