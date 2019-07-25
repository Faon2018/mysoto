package com.faon.service;

import com.faon.entity.Permission;

import java.util.List;

public interface PermissionService {

    Permission getPermissionById(int id);

    List<Permission> getPermissionsByUserId(int userId);
}
