package com.faon.service.impl;

import com.faon.dao.PermissionMapper;
import com.faon.entity.Permission;
import com.faon.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public Permission getPermissionById(int id) {
        return permissionMapper.getPermissionById(id);
    }

    @Override
    public List<Permission> getPermissionsByUserId(int userId) {
        return permissionMapper.getPermissionsByUserId(userId);
    }
}
