package com.ith.betta.web.dao.impl;

import com.ith.betta.web.dao.UserDetailsDao;
import com.ith.betta.web.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUserByUsername(String username) {
        return sessionFactory.getCurrentSession().get(User.class, username);
    }
}
