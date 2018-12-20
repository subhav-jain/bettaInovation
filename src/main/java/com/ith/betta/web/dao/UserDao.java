package com.ith.betta.web.dao;

import com.ith.betta.web.models.User;

import java.util.List;

public interface UserDao {

    void save(User user);
    List<User> list();
    User findByUsername(String username);

}
