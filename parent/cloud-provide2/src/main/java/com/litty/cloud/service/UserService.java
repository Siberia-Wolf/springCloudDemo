package com.litty.cloud.service;

import com.litty.cloud.entity.User;

import java.util.List;

public interface UserService {

    public User findUserById(String id);

    public List<User> findUserAll();
}
