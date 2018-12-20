package com.ith.betta.web.dao;

import com.ith.betta.web.models.User;

public interface UserDetailsDao {
    User findUserByUsername(String username);
}
