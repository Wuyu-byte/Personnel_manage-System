package com.xlk.service.impl;

import com.xlk.mapper.UserMapper;
import com.xlk.pojo.User;
import com.xlk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.Login(user);
    }

    @Override
    public void updatePassword(User user) {
        userMapper.UpdatePassword(user);
    }
}
