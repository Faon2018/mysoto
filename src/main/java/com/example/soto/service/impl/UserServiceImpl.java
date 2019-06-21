package com.example.soto.service.impl;

import com.example.soto.dao.UserMapper;
import com.example.soto.entity.User;
import com.example.soto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private  UserMapper  userMapper;
    @Override
    public User get() {
        return  userMapper.selectById();
    }
}
