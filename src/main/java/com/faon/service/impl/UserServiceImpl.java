package com.faon.service.impl;

import com.faon.dao.UserMapper;
import com.faon.entity.User;
import com.faon.service.UserService;
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
