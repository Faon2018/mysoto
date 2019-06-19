package com.example.soto.dao;

import com.example.soto.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectById();

}
