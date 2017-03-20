package com.kaer.athena.users.dao;

import com.kaer.athena.users.entity.UserEntity;

import java.util.List;

/**
 * Created by Kelvin on 2017/3/20.
 */
public interface UserDao {
    List<UserEntity> getAllUsers();
}
