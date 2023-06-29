package com.example.shixun.service;

import com.example.shixun.mapper.UserMapper;
import com.example.shixun.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl  implements UserService{


    @Resource
    UserMapper userMapper;

    @Override
    public User login(String name) {
        return userMapper.login(name);
    }
}