package com.ith.betta.web.services.impl;

import com.ith.betta.web.dao.UserDao;
import com.ith.betta.web.models.User;
import com.ith.betta.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> list() {
        return userDao.list();
    }

    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
