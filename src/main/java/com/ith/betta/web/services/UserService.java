package com.ith.betta.web.services;

import com.ith.betta.web.models.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> list();

    User getUserByUsername(String username);
}

