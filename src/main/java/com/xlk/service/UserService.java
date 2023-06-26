package com.xlk.service;

import com.xlk.pojo.User;

public interface UserService {
    public User login(User user);
    void updatePassword(User user);
}
