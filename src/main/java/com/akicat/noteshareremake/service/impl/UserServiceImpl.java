package com.akicat.noteshareremake.service.impl;

import com.akicat.noteshareremake.mapper.UserMapper;
import com.akicat.noteshareremake.model.User;
import com.akicat.noteshareremake.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getCheckUser(String username, String password) {
        return userMapper.getCheckUser(username, password);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User getUserFromUserId(int id) {
        return userMapper.getUserFromUserId(id);
    }

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }

    @Override
    public int updateUserPass(User user) {
        return userMapper.updateUserPass(user);
    }
}