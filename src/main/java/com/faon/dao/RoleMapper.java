package com.faon.dao;

import com.faon.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    Role getRoleByid(int id);

    List<Role> getRolesByUserId(int userId);
}
