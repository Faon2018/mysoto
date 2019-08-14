package com.faon.service.impl;

import com.faon.dao.RoleMapper;
import com.faon.entity.Role;
import com.faon.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Role getRoleById(int id) {
        return roleMapper.getRoleById(id);
    }

    @Override
    public List<Role> getRolesByUserId(int userId) {
        return roleMapper.getRolesByUserId(userId);
    }
}
