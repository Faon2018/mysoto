package com.faon.dao;

import com.faon.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserRolePermissionById(int userId);

    User  getUserByName(String username);

    Boolean  addUser(User user);
}
