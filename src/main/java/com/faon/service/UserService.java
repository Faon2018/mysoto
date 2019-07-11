package com.faon.service;

import com.faon.entity.User;

public interface UserService {

    User getUserRolePermissionById(int userId);

    User  getUserByName(String username);

    Boolean  addUser(User user);
}
