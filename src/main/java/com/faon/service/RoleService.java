package com.faon.service;

import com.faon.entity.Role;

import java.util.List;

public interface RoleService {

    Role  getRoleById(int id);

    List<Role> getRolesByUserId(int userId);
}
