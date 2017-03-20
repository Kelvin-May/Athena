package com.kaer.athena.users.service.impl;

import com.kaer.athena.users.dao.UserDao;
import com.kaer.athena.users.entity.UserEntity;
import com.kaer.athena.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kelvin on 2017/3/20.
 */
@Service
public interface UserServiceImpl {

    List<UserEntity> getAllUsers();
}
