package com.kaer.athena.users.service;

import com.kaer.athena.users.dao.UserDao;
import com.kaer.athena.users.entity.UserEntity;
import com.kaer.athena.users.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kelvin on 2017/3/20.
 */
@Service
public class UserService implements UserServiceImpl {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserEntity> getAllUsers() {
        return userDao.getAllUsers();
    }
}
