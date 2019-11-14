package com.biblioteka.authorization.service;

import com.biblioteka.authorization.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
